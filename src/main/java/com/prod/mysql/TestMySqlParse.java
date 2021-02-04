package com.prod.mysql;

import com.prod.mysql.parse.MySqlLexer;
import com.prod.mysql.parse.MySqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class TestMySqlParse {

    public static void main(String[] args) {

        String sql = "select * from (select * from tb) as a";

        MySqlLexer lexer = new MySqlLexer(new ANTLRInputStream(sql));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        //解析器
        MySqlParser mySqlParser = new MySqlParser(tokenStream);
        System.out.println(mySqlParser);
        System.out.println(mySqlParser.root());
        mySqlParser.root();

    }
}
