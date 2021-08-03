package com.elminster.calc.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.elminster.calc.Calculator;
import com.elminster.calc.impl.RPNCalculator;
import com.elminster.calc.model.CalculationRequest;
import com.elminster.calc.model.CalculationResult;
import com.elminster.calc.model.SimpleCalculationRequest;
import com.elminster.calc.ops.exceptions.CalculationException;
import com.elminster.calc.ops.model.CalculationModel;
import com.elminster.calc.ops.model.CalcululationContext;
import com.elminster.calc.ops.model.RPNCalculateContext;
import com.elminster.calc.ops.model.RPNCalculatorModel;
import com.elminster.calc.ops.printer.impl.RPNCalculationModelPrinter;


public class CalculatorTest {
  
  @Test
  public void TestCalculator1() throws CalculationException {
    System.out.println("Ex1:"); 
    CalcululationContext ctx = new RPNCalculateContext();
    CalculationModel<BigDecimal> model = new RPNCalculatorModel();
    ctx.setModel(model);
    Calculator calc = new RPNCalculator();
    
    String input = "5 2";
    CalculationRequest request = new SimpleCalculationRequest(input);
    CalculationResult result = calc.calculate(ctx, request);
    RPNCalculationModelPrinter printer = new RPNCalculationModelPrinter();
    Assert.assertEquals(toStack("5", "2"), printer.print(result.getResult()));
  }
  
  @Test
  public void TestCalculator2() throws CalculationException {
    System.out.println("Ex2:"); 
    CalcululationContext ctx = new RPNCalculateContext();
    CalculationModel<BigDecimal> model = new RPNCalculatorModel();
    ctx.setModel(model);
    Calculator calc = new RPNCalculator();
    RPNCalculationModelPrinter printer = new RPNCalculationModelPrinter();
    
    String input = "2 sqrt";
    CalculationRequest request = new SimpleCalculationRequest(input);
    CalculationResult result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("1.4142135624"), printer.print(result.getResult()));
    
    input = "clear 9 sqrt";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("3.0"), printer.print(result.getResult()));
  }
  
  @Test
  public void TestCalculator3() throws CalculationException {
    System.out.println("Ex3:"); 
    CalcululationContext ctx = new RPNCalculateContext();
    CalculationModel<BigDecimal> model = new RPNCalculatorModel();
    ctx.setModel(model);
    Calculator calc = new RPNCalculator();
    RPNCalculationModelPrinter printer = new RPNCalculationModelPrinter();
    
    String input = "5 2 -";
    CalculationRequest request = new SimpleCalculationRequest(input);
    CalculationResult result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("3"), printer.print(result.getResult()));
    
    input = "3 -";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("0"), printer.print(result.getResult()));

    input = "clear";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack(new String[0]), printer.print(result.getResult()));
  }
  
  private String toStack(String...strings) {
    StringBuilder sb = new StringBuilder("stack:");
    if (null != strings) {
      for (String s : strings) {
        sb.append(" ").append(s);
      }
    }
    return sb.toString();
  }

  @Test
  public void TestCalculator4() throws CalculationException {
    System.out.println("Ex4:");
    CalcululationContext ctx = new RPNCalculateContext();
    CalculationModel<BigDecimal> model = new RPNCalculatorModel();
    ctx.setModel(model);
    Calculator calc = new RPNCalculator();
    RPNCalculationModelPrinter printer = new RPNCalculationModelPrinter();
    
    String input = "5 4 3 2";
    CalculationRequest request = new SimpleCalculationRequest(input);
    CalculationResult result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("5", "4", "3", "2"), printer.print(result.getResult()));
    
    input = "undo undo *";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("20"), printer.print(result.getResult()));
    
    input = "5 *";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("100"), printer.print(result.getResult()));
    
    input = "undo";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("20", "5"), printer.print(result.getResult()));
  }
  
  @Test
  public void TestCalculator5() throws CalculationException {
    System.out.println("Ex5:");
    CalcululationContext ctx = new RPNCalculateContext();
    CalculationModel<BigDecimal> model = new RPNCalculatorModel();
    ctx.setModel(model);
    Calculator calc = new RPNCalculator();
    RPNCalculationModelPrinter printer = new RPNCalculationModelPrinter();
    
    String input = "7 12 2 /";
    CalculationRequest request = new SimpleCalculationRequest(input);
    CalculationResult result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("7", "6"), printer.print(result.getResult()));
    
    input = "*";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("42"), printer.print(result.getResult()));
    
    input = "4 /";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("10.5"), printer.print(result.getResult()));
  }
  
  @Test
  public void TestCalculator6() throws CalculationException {
    System.out.println("Ex6:");
    CalcululationContext ctx = new RPNCalculateContext();
    CalculationModel<BigDecimal> model = new RPNCalculatorModel();
    ctx.setModel(model);
    Calculator calc = new RPNCalculator();
    RPNCalculationModelPrinter printer = new RPNCalculationModelPrinter();
    
    String input = "1 2 3 4 5";
    CalculationRequest request = new SimpleCalculationRequest(input);
    CalculationResult result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("1", "2", "3", "4", "5"), printer.print(result.getResult()));
    
    input = "*";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("1", "2", "3", "20"), printer.print(result.getResult()));
    
    input = "clear 3 4 -";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("-1"), printer.print(result.getResult()));
  }
  
  @Test
  public void TestCalculator7() throws CalculationException {
    System.out.println("Ex7:");
    CalcululationContext ctx = new RPNCalculateContext();
    CalculationModel<BigDecimal> model = new RPNCalculatorModel();
    ctx.setModel(model);
    Calculator calc = new RPNCalculator();
    RPNCalculationModelPrinter printer = new RPNCalculationModelPrinter();
    
    String input = "1 2 3 4 5";
    CalculationRequest request = new SimpleCalculationRequest(input);
    CalculationResult result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("1", "2", "3", "4", "5"), printer.print(result.getResult()));
    
    input = "* * * *";
    request = new SimpleCalculationRequest(input);
    result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("120"), printer.print(result.getResult()));
  }
  
  @Test
  public void TestCalculator8() throws CalculationException {
    System.out.println("Ex8:");
    CalcululationContext ctx = new RPNCalculateContext();
    CalculationModel<BigDecimal> model = new RPNCalculatorModel();
    ctx.setModel(model);
    Calculator calc = new RPNCalculator();
    RPNCalculationModelPrinter printer = new RPNCalculationModelPrinter();
    
    String input = "1 2 3 * 5 + * * 6 5";
    CalculationRequest request = new SimpleCalculationRequest(input);
    CalculationResult result = calc.calculate(ctx, request);
    Assert.assertEquals(toStack("11"), printer.print(result.getResult()));
  }
}
