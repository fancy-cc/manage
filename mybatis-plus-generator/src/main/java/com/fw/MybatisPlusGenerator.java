package com.fw;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class MybatisPlusGenerator {
    /*private static final Logger logger = LoggerFactory.getLogger(MybatisPlusGenerator.class);
    // 模块名称
    static final String moduleName = "manage";
    // 生成代码的位置
    static final String projectPath = "/Users/fanbotao/fanbt/fw/manage/manage-service";
    // 数据库相关配置
    static final String dbUrl = "jdbc:mysql://10.111.196.174:3306/manage";

    static final String dbUserName = "root";

    static final String dbPassWord = "password!@#";
    // 所需的表
    static String[] tableNames = {"user"};

    public static void main(String[] args) {

        if (true) {
            Cfg cfg = new Cfg();
            cfg.setTableNames(tableNames);
            cfg.setProjectPath(projectPath);
            cfg.setNeedToGenMapperXml(true); // 生成mapper文件
            cfg.setNeedToGenService(false); // 不生成service
            cfg.setNeedToGenController(false); // 不生成controller
            gen(cfg);
        }

    }

    private static void gen(Cfg cfg) {
        // 代码生成器
        ExtendedAutoGenerator mpg = new ExtendedAutoGenerator();

        // =============================全局配置===============================
        GlobalConfig gc = new GlobalConfig()
                // 生成文件的位置
                .setFileOverride(true).setOutputDir(projectPath+ "/src/main/java")
                // 主键生成策略 生成BaseResultMap和BaseColumnList
                .setIdType(IdType.AUTO).setBaseResultMap(true).setBaseColumnList(true)
                // 指定作者
                .setAuthor("Van")
                // 设置Controller、Service、ServiceImpl、Dao、Mapper文件名称，%s是依据表名转换来的
//                .setControllerName("%sController").setServiceName("MP%sService").setServiceImplName("%sServiceImpl")
                // 设置Dao、Mapper文件名称，%s是依据表名转换来的
                .setMapperName("%sDao").setXmlName("%sMapper").setEntityName("%sDO")
                // 生成swagger字段说明
//                .setSwagger2(true)
                .setOpen(false).setKotlin(false);
        mpg.setGlobalConfig(gc);
        // ================================数据源配置============================
        DataSourceConfig dsc = new DataSourceConfig();
        // 用户名、密码、驱动、url
        dsc.setDbType(DbType.MYSQL).setDriverName("com.mysql.jdbc.Driver")
                .setUrl(dbUrl).setUsername(dbUserName).setPassword(dbPassWord);
        mpg.setDataSource(dsc);

        // ===============================包名配置：父包.模块.controller===============================
        PackageConfig pc = new PackageConfig();
        // 父包名 模块名
        pc.setParent("cn.van").setModuleName(moduleName)
                // 分层包名
//      .setController("controller").setService("service").setServiceImpl("service.impl")
                .setEntity("entity").setMapper("dao");
        mpg.setPackageInfo(pc);
        // =====================================策略配置==================================
        StrategyConfig strategy = new StrategyConfig();
        // 命名策略：实体的类名和属性名按下划线转驼峰 user_info -> userInfo
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.sbt.zhichu.entity.BaseEntity");
        strategy.setEntityLombokModel(true);
        //strategy.setSuperControllerClass("com.baomidou.mybatisplus.samples.generator.common.BaseController");
        if (cfg.getTableNames() != null) {
            strategy.setInclude(cfg.getTableNames());
        } else {
            strategy.setInclude(scanner("表名"));
        }
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        // =====================================自定义配置==================================
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList();
        if (cfg.isNeedToGenMapperXml()) {
            focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
        }
        injectionConfig.setFileOutConfigList(focList);
        mpg.setCfg(injectionConfig);
        TemplateConfig templateConfig = new TemplateConfig().setXml(null);
        mpg.setTemplate(templateConfig);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        AbstractTemplateEngine templateEngine = new FreemarkerTemplateEngine();
        mpg.setTemplateEngine(templateEngine);

        // 忽略service跟controller生成，把mpg.execute()方法拆解开自行定制
        //mpg.execute();
        logger.debug("==========================准备生成文件...==========================");
        ConfigBuilder configBuilder = new ConfigBuilder(pc, dsc, strategy, templateConfig, gc);
        configBuilder.setInjectionConfig(injectionConfig);
        List<TableInfo> tableInfoList = configBuilder.getTableInfoList();
        for (TableInfo tableInfo : tableInfoList) {
            if (!cfg.isNeedToGenService()) {
                tableInfo.setServiceName(null);
                tableInfo.setServiceImplName(null);
            }
            if (!cfg.isNeedToGenController()) {
                tableInfo.setControllerName(null);
            }
        }
        // 模板引擎初始化执行文件输出
        templateEngine.init(mpg.pretreatmentConfigBuilder(configBuilder)).mkdirs().batchOutput().open();
        logger.debug("==========================文件生成完成！！！==========================");

    }
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
    private static class ExtendedAutoGenerator extends AutoGenerator {
        @Override
        public ConfigBuilder pretreatmentConfigBuilder(ConfigBuilder config) {
            return super.pretreatmentConfigBuilder(config);
        }
    }

    @Data
    private static class Cfg {
        private String[] tableNames;
        private String projectPath;
        private boolean needToGenMapperXml = false;
        private boolean needToGenService = false;
        private boolean needToGenController = false;

        public String[] getTableNames() {
            return tableNames;
        }

        public void setTableNames(String[] tableNames) {
            this.tableNames = tableNames;
        }

        public String getProjectPath() {
            return projectPath;
        }

        public void setProjectPath(String projectPath) {
            this.projectPath = projectPath;
        }

        public boolean isNeedToGenMapperXml() {
            return needToGenMapperXml;
        }

        public void setNeedToGenMapperXml(boolean needToGenMapperXml) {
            this.needToGenMapperXml = needToGenMapperXml;
        }

        public boolean isNeedToGenService() {
            return needToGenService;
        }

        public void setNeedToGenService(boolean needToGenService) {
            this.needToGenService = needToGenService;
        }

        public boolean isNeedToGenController() {
            return needToGenController;
        }

        public void setNeedToGenController(boolean needToGenController) {
            this.needToGenController = needToGenController;
        }
    }*/
}
