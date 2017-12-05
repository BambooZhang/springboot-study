import bamboo.Application;
import bamboo.Article;
import bamboo.ArticleSearchRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.*;


/**
 *
 * Created by xialeme on 2017/11/30.
 * spring data elsaticsearch提供了三种构建查询模块的方式：
 1. 基本的增删改查：继承spring data提供的接口就默认提供
 2. 接口中声明方法：无需实现类，spring data根据方法名，自动生成实现类，方法名必须符合一定的规则（这里还扩展出一种忽略方法名，根据注解的方式查询）,样例参考：ArticleSearchRepository
 3. 自定义repository：在实现类中注入elasticsearchTemplate，实现上面两种方式不易实现的查询（例如：聚合、分组、深度翻页等）
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes=Application.class)
@SpringBootTest(classes= Application.class)
public class ArticleSearchRepositoryTest {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    /*测试自动创建mapping
    *curl '192.168.0.91:9200/_cat/indices?v'
    * curl -XGET "http://192.168.0.91:9200/article_index/_mapping?pretty"
    *
    *  */
    @Test
    public void test(){
        System.out.println("演示初始化");
    }



    /*
    *保存测试
    * curl '192.168.0.91:9200/article_index/article/_search?q=*&pretty'
     */
    @Test
    public void testSave(){
        Article article=new Article(3L,"srpignMVC教程","srpignMVC","srpignMVC入门到放弃",new Date(),22L);
        Article article1=new Article(4L,"srpig教程","spring","spring入门到放弃",new Date(),20L);
        Article article2=new Article(5L,"srpigCloud教程","springCloud","springCloud入门到放弃",new Date(),20L);
        Article article3=new Article(6L,"java教程","java","java入门到放弃",new Date(),120L);
        Article article4=new Article(7L,"php教程","php","php入门到放弃",new Date(),160L);

//        articleSearchRepository.save(article);
//        articleSearchRepository.save(article1);
//        articleSearchRepository.save(article2);
//        articleSearchRepository.save(article3);
//        articleSearchRepository.save(article4);

        Article article8=new Article(8L,"mysql教程","mysql","mysql入门到放弃",new Date(),460L);
        Article article9=new Article(9L,"redis教程","redis","redis入门到放弃",new Date(),60L);
        Article article10=new Article(10L,"c教程","c","c教程入门到放弃",new Date(),600L);
        //bulk index 批量方式插入
        List<Article> sampleEntities = Arrays.asList( article10);
        articleSearchRepository.save(sampleEntities);

    }



    /*
    *获取所有测试
    * curl '192.168.0.91:9200/article_index/article/_search?q=*&pretty'
     */
    @Test
    public void testFetchAll(){
        for (Article article : articleSearchRepository.findAll()) {
            System.out.println(article.toString());
        }
    }


   /*
   *精确查找
   * curl '192.168.0.91:9200/article_index/article/_search?q=*&pretty'
    */
    @Test
    public void testFetchArticle(){
        for (Article article : articleSearchRepository.findByTitle("srpignboot教程")) {
            System.out.println(article.toString());
        }
    }




    /*
  *分页测试
  * curl '192.168.0.91:9200/article_index/article/_search?q=*&pretty'
   */
    @Test
    public void testPage(){

        List<Article> list;
        // list=articleSearchRepository.findByTitleAndClickCount("教程",20 );//and
        // list=articleSearchRepository.findByTitleOrClickCount("教程",20 );//or

        // 分页参数:分页从0开始，clickCount倒序
        Pageable pageable = new PageRequest(0, 5, Sort.Direction.DESC,"clickCount");
        Page<Article> pageageRsutl=articleSearchRepository.findByContent("入门",pageable );
        System.out.println("总页数"+pageageRsutl.getTotalPages());
        list= pageageRsutl.getContent();//结果


        for (Article article : list) {
            System.out.println(article.toString());
        }
    }


    /*
   *其他查找
   * curl '192.168.0.91:9200/article_index/article/_search?q=*&pretty'
    */
    @Test
    public void testDls(){

        List<Article> list;

        // 创建搜索 DSL:多条件搜索
         /* 搜索模式: boolQuery */
        Pageable pageable = new PageRequest(0, 5);//分页
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(boolQuery().should(QueryBuilders.matchQuery("content", "教程")),
                        ScoreFunctionBuilders.weightFactorFunction(100))
                .add(boolQuery().should(QueryBuilders.matchQuery("clickCount", 20)),
                        ScoreFunctionBuilders.weightFactorFunction(1000));


        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();

        System.out.println("\n search  DSL  = \n " + searchQuery.getQuery().toString());

        Page<Article> searchPageResults = articleSearchRepository.search(searchQuery);
        list= searchPageResults.getContent();//结果

        for (Article article : list) {
            System.out.println(article.toString());
        }
    }



    /*
   *聚合查询测试
   * curl '192.168.0.91:9200/article_index/article/_search?q=*&pretty'
    */
    @Test
    public void testScore(){

        List<Article> list;

        // 创建搜索 DSL 查询:weightFactorFunction是评分函数，官网的控制相关度中有详细讲解价格，地理位置因素
         /* 搜索模式 */
        String SCORE_MODE_SUM = "sum"; // 权重分求和模式
        Float  MIN_SCORE = 10.0F;      // 由于无相关性的分值默认为 1 ，设置权重分最小值为 10
        // Function Score Query
        Pageable pageable = new PageRequest(0, 5);
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(boolQuery().should(QueryBuilders.matchQuery("content", "教程")),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(boolQuery().should(QueryBuilders.matchQuery("clickCount", 20)),
                        ScoreFunctionBuilders.weightFactorFunction(1000)).
                        scoreMode(SCORE_MODE_SUM).setMinScore(MIN_SCORE);//分值模式设置为:求和,


        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable).build();

        System.out.println("\n search  DSL  = \n " + searchQuery.getQuery().toString());

        Page<Article> searchPageResults = articleSearchRepository.search(searchQuery);
        list= searchPageResults.getContent();//结果

        for (Article article : list) {
            System.out.println(article.toString());
        }
    }


    /*
      *elasticsearchTemplate自定义查询：提交时间倒叙
      *elasticsearchTemplate
      * curl '192.168.0.91:9200/article_index/article/_search?q=*&pretty'
      */
    @Test
    public void etmTest() {


        //查询关键字
        String word="c入门";

        // 分页设置,postTime倒序
        Pageable pageable = new PageRequest(0, 10, Sort.Direction.DESC,"postTime");

        SearchQuery searchQuery;

        //0.使用queryStringQuery完成单字符串查询queryStringQuery(word, "title")
        //1.multiMatchQuery多个字段匹配 .operator(MatchQueryBuilder.Operator.AND)多项匹配使用and查询即完全匹配都存在才查出来
        //searchQuery = new NativeSearchQueryBuilder().withQuery(multiMatchQuery(word, "title", "content").operator(MatchQueryBuilder.Operator.AND)).withPageable(pageable).build();

        //2.多条件查询：title和content必须包含word=“XXX”且clickCount必须大于200的以postTime倒序分页结果
        word="教程";
        searchQuery = new NativeSearchQueryBuilder().withQuery(boolQuery().must(multiMatchQuery(word, "title", "content").operator(MatchQueryBuilder.Operator.AND)).must(rangeQuery("clickCount").gt(200))).withPageable(pageable).build();

        List<Article> list= elasticsearchTemplate.queryForList(searchQuery, Article.class);

        for (Article article : list) {
            System.out.println(article.toString());
        }
    }


}