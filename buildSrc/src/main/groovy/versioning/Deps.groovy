package versioning


interface Deps {

    interface Versions {
        String ANNOTATION        = "1.3.2"
        String CDI               = "2.0.SP1"
        String CONCURRENT        = "1.1"
        String EBEAN             = "11.27.1"
        String EBEAN_ANNOTATIONS = "4.3"
        String EBEAN_QUERY       = "11.24.1"
        String EBEAN_QUERY_GEN   = "11.24.1"
        String EBEAN_TEST        = "11.27.1"
        String JACKSON           = "2.9.7"
        String JACKSON_COREUTILS = "1.8"
        String JACKSON_MONEY     = "1.1.0"
        String JAX_RS            = "2.1.1"
        String JAXB              = "2.4.0-b180830.0359"
        String JAXB_RUNTIME      = "2.4.0-b180830.0438"
        String JHIPSTER          = "2.0.28"
        String JJWT              = "0.9.1"
        String JSON_PATCH        = "1.9"
        String OKHTTP            = "3.12.0"
        String OPENAPI           = "2.0.6"
        String POI               = "4.0.0"
        String RESTEASY          = "3.6.1.Final"
        String RESTEASY_BOOT     = "2.0.1.Final"
        String TRANSACTION       = "1.3"
        String VALIDATION        = "2.0.1.Final"
        String VALIDATOR         = "6.0.13.Final"
        String ZALANDO_PROBLEM   = "0.22.0"
    }

    interface Platforms {
        String JHIPSTER          = "io.github.jhipster:jhipster-framework:${Versions.JHIPSTER}"
    }
    interface Javax {
        String ANNOTATION   = "javax.annotation:javax.annotation-api:${Versions.ANNOTATION}"
        String CDI          = "javax.enterprise:cdi-api:${Versions.CDI}"
        String CONCURRENT   = "javax.enterprise.concurrent:javax.enterprise.concurrent-api:${Versions.CONCURRENT}"
        String INJECT       = "javax.inject:javax.inject:1"
        String JAX_RS       = "javax.ws.rs:javax.ws.rs-api:${Versions.JAX_RS}"
        String JAXB         = "javax.xml.bind:jaxb-api:${Versions.JAXB}"
        String JAXB_RUNTIME = "org.glassfish.jaxb:jaxb-runtime:${Versions.JAXB_RUNTIME}"
        String TRANSACTION  = "javax.transaction:javax.transaction-api:${Versions.TRANSACTION}"
        String VALIDATION   = "javax.validation:validation-api:${Versions.VALIDATION}"
    }
    interface Libs {
        String EBEAN                       = "io.ebean:ebean:${Versions.EBEAN}"
        String EBEAN_ANNOTATIONS           = "io.ebean:ebean-annotation:${Versions.EBEAN_ANNOTATIONS}"
        String EBEAN_QUERY                 = "io.ebean:ebean-querybean:${Versions.EBEAN_QUERY}"
        String EBEAN_QUERY_GEN             = "io.ebean:querybean-generator:${Versions.EBEAN_QUERY_GEN}"
        String EBEAN_TEST                  = "io.ebean.test:ebean-test-config:${Versions.EBEAN_TEST}"
        String JACKSON_AFTERBURNER         = "com.fasterxml.jackson.module:jackson-module-afterburner:${Versions.JACKSON}"
        String JACKSON_ANNOTATIONS         = "com.fasterxml.jackson.core:jackson-annotations:${Versions.JACKSON}"
        String JACKSON_CORE                = "com.fasterxml.jackson.core:jackson-core:${Versions.JACKSON}"
        String JACKSON_COREUTILS           = "com.github.fge:jackson-coreutils:${Versions.JACKSON_COREUTILS}"
        String JACKSON_CSV                 = "com.fasterxml.jackson.dataformat:jackson-dataformat-csv:${Versions.JACKSON}"
        String JACKSON_DATABIND            = "com.fasterxml.jackson.core:jackson-databind:${Versions.JACKSON}"
        String JACKSON_HPPC                = "com.fasterxml.jackson.datatype:jackson-datatype-hppc:${Versions.JACKSON}"
        String JACKSON_JAXB_ANNOTATIONS    = "com.fasterxml.jackson.module:jackson-module-jaxb-annotations:${Versions.JACKSON}"
        String JACKSON_JAXRS_BASE          = "com.fasterxml.jackson.jaxrs:jackson-jaxrs-base:${Versions.JACKSON}"
        String JACKSON_JAXRS_JSON_PROVIDER = "com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider:${Versions.JACKSON}"
        String JACKSON_JDK8                = "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:${Versions.JACKSON}"
        String JACKSON_JSON_ORG            = "com.fasterxml.jackson.datatype:jackson-datatype-json-org:${Versions.JACKSON}"
        String JACKSON_JSR310              = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Versions.JACKSON}"
        String JACKSON_MONEY               = "org.zalando:jackson-datatype-money:${Versions.JACKSON_MONEY}"
        String JACKSON_PARAMETER           = "com.fasterxml.jackson.module:jackson-module-parameter-names:${Versions.JACKSON}"
        String JJWT                        = "io.jsonwebtoken:jjwt:${Versions.JJWT}"
        String JSON_PATCH                  = "com.github.fge:json-patch:${Versions.JSON_PATCH}"
        String OKHTTP                      = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        String OKHTTP_LOG                  = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
        String OKHTTP_URL                  = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.OKHTTP}"
        String OPENAPI_JAXRS2              = "io.swagger.core.v3:swagger-jaxrs2:${Versions.OPENAPI}"
        String OPENAPI_MODELS              = "io.swagger.core.v3:swagger-models:${Versions.OPENAPI}"
        String POI                         = "org.apache.poi:poi:${Versions.POI}"
        String POI_XML                     = "org.apache.poi:poi-ooxml:${Versions.POI}"
        String POI_XML_SCHEMAS             = "org.apache.poi:poi-ooxml-schemas:${Versions.POI}"
        String RESTEASY_BOOT               = "org.jboss.resteasy:resteasy-spring-boot-starter:${Versions.RESTEASY_BOOT}"
        String RESTEASY_CLIENT             = "org.jboss.resteasy:resteasy-client:${Versions.RESTEASY}"
        String VALIDATOR                   = "org.hibernate.validator:hibernate-validator:${Versions.VALIDATOR}"
        String VALIDATOR_AP                = "org.hibernate.validator:hibernate-validator-annotation-processor:${Versions.VALIDATOR}"
        String ZALANDO_PROBLEM             = "org.zalando:problem:${Versions.ZALANDO_PROBLEM}"
        String ZALANDO_PROBLEM_JACK        = "org.zalando:jackson-datatype-problem:${Versions.ZALANDO_PROBLEM}"
    }
}


