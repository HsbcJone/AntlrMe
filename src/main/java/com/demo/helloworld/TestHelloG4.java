package com.demo.helloworld;

import com.demo.helloworld.parse.HelloLexer;
import com.demo.helloworld.parse.HelloParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * 参考该文章
 * https://cloud.tencent.com/developer/article/1556983
 * 概念文章
 * https://zhuanlan.zhihu.com/p/114982293
 * 词法分析器 (Lexer) -> 语法解析器 (Parser)
 */
public class TestHelloG4 {
    public static void main(String[] args) {
        String content="hello mengx asd asd ";
        //1.0 获取输入流
        ANTLRInputStream inputStream = new ANTLRInputStream(content);
        HelloLexer lexer = new HelloLexer(inputStream);
        //2.0 使用词法解析器
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokenStream);
        //3.0 使用语法解析器
        ParseTreeWalker walker = new ParseTreeWalker();
        MyLister demoLister = new MyLister();
        walker.walk(demoLister, parser.r());
        //4.0 输出结果
        System.out.println(demoLister.result);
    }
}
