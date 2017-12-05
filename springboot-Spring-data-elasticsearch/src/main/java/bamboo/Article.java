package bamboo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

/**
 * Created by xialeme on 2017/11/30.
 */
@Document(indexName="article_index",type="article",shards=5,replicas=1,indexStoreType="fs",refreshInterval="-1")
public class Article implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 551589397625941750L;
    @Id
    private Long id;
    /**标题*/
   // @Field(index= FieldIndex.not_analyzed,store=true,type=FieldType.String)
    private String title;
    /**摘要*/
    private String abstracts;
    /**内容*/
    private String content;
    /**发表时间*/
    @Field(format=DateFormat.date_time,index=FieldIndex.not_analyzed,store=true,type= FieldType.Object)
    private Date postTime;
    /**点击率*/
    private Long clickCount;

    //setters and getters
    //toString

    public Article() {
    }

    public Article(Long id, String title, String abstracts, String content, Date postTime, Long clickCount) {
        this.id = id;
        this.title = title;
        this.abstracts = abstracts;
        this.content = content;
        this.postTime = postTime;
        this.clickCount = clickCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", abstracts='" + abstracts + '\'' +
                ", content='" + content + '\'' +
                ", postTime=" + postTime +
                ", clickCount=" + clickCount +
                '}';
    }
}
