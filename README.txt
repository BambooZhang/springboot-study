
 ÿ��ҵ�������ö�����MYSQL���ݿ⣬���ڿ����õ����������

����ע�ᡢ����: eureka
���ù���:spring config , spring security
��Ⱥ�ݴ�: hystrix����ʵ�֣�
API����: zuul����ʵ�֣�
������:feign+ribbon
api�ĵ����:swagger2
�����:lombok
��Ϣ����:rabbitmq
�ֲ�ʽ��: redis ����ʵ�֣�
��·����:spring cloud sletuh ->zipkin
��ȫ��֤:oauth2/JWT(��ʵ��)
������:spring-boot-admin



��ģ�����

ģ������	�˿�	���
admin-server	9002	���������ģ�������з���ģ��
conf-server	9004	�ֲ�ʽ�������ģ����spring-security/rabbitmqͬʱʹ��
eureka-server	9003	����ע�����ģ��ṩ����ע�ᡢ���ֹ���
sleuth-server	9001	SpringCloudʵ�ֵ�һ�ֲַ�ʽ׷�ٽ������������Zipkin
zuul-server	9005	API����ģ��
account-service	8080	�û������ṩע�ᡢ��¼����ַ�ȷ���
product-service	8081	��Ʒ�����ṩ��Ʒ�б����顢�����µȷ���
payment-service	8082	֧������֧����¼
order-service	8083	���������ṩ�������������顢״̬���
msg-service	8084	��Ϣ�������
front-app	8088	ǰ�˷��񣬽��swagger2�ṩAPI����








��������

1��������admin-server,eureka-server,conf-server������������
2������������payment/order/product/account����ҵ�����
3���������front-app���񣬴������������http://localhost:8088/swagger-ui.html ����������API���ο�ʹ�ù���
4��������ʱ�����ṩҳ�棬����VUE2+BOOTSTRAP�������̴�����
Release Version

v2.1

Release Date : 2017-08-29
1������swagger2�����API�ӿ��ĵ������������ҵ������������ת

2��ͨ��API�ӿ��������ҵ������

3������Spring-cloud-config�����������ģ����security��ǿ��ȫ���ã�ͬʱ����bus-amqp(rabbitmq)��Ч������������[�����������ݽ��sc-cloud-repo����ʹ��]

4������feign������ͻ��˵��÷���˵ķ���

5������ribbon����������ͻ��˵ĸ��ؾ�����ú�˷���

v1.0

Release Date : 2017-08-17
1����ɻ�������ҵ����ģ�����Ĵ ��ҵ����ģ�����������

2�����SpringBootAdminҵ��ģ������м�أ���Eureka�������У������ҵ����������ע�ᡢ���ֹ���

3����ͨ��Front-app�ˣ�����Feign�������login/signup�ȹ��ܵ� �򵥲������С�

��һ�汾�������ڴ˰汾֮�ϣ��������������Ĺ���ʵ�֣������򵥵�ҳ�桢api����/���õȵȡ�