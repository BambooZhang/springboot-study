# springboot-rabbitmq
目录结构如下
```
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      ├─bamboo
│  │  │      └─callback
│  │  │          └─config
│  │  └─resources
│  └─test
│      └─java
└─target
  
```

- com.bamboo包下为自动配置，默认已经把这下面的每个类名上的注解注释掉了
- com.callback包下为手工配置的需要手工确认并调用回掉方法

以上两种模式：
第一种自动配置的需要去掉com.bamboo包下类的注释，并把com.callback包下的所有类的头部注解注释上