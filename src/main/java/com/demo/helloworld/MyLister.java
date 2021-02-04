package com.demo.helloworld;

import com.demo.helloworld.parse.HelloBaseListener;
import com.demo.helloworld.parse.HelloParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MyLister extends HelloBaseListener {

    /**
     * 需要输出的hello后面的小谢字符串
     */
    public String result;
    private final String start="hello";

    @Override
    public void enterR(HelloParser.RContext ctx) {
        super.enterR(ctx);
        System.out.println("2.enterR");
    }

    @Override
    public void exitR(HelloParser.RContext ctx) {
        super.exitR(ctx);
        System.out.println("4.exitR");

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
        System.out.println("1.enterEveryRule");
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
        System.out.println("5.exitEveryRule");
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        System.out.println("3.visitTerminal");
        super.visitTerminal(node);
        if(!node.getText().equalsIgnoreCase(start)){
            result=node.getText();
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        System.out.println("错误的节点是:"+node);
        super.visitErrorNode(node);
    }
}
