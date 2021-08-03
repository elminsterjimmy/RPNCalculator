package com.elminster.calc.app;

import java.math.BigDecimal;
import java.util.Scanner;

import com.elminster.calc.Calculator;
import com.elminster.calc.impl.RPNCalculator;
import com.elminster.calc.model.SimpleCalculationRequest;
import com.elminster.calc.model.SimpleCalculationResult;
import com.elminster.calc.ops.model.CalculationModel;
import com.elminster.calc.ops.model.CalcululationContext;
import com.elminster.calc.ops.model.RPNCalculateContext;
import com.elminster.calc.ops.model.RPNCalculatorModel;
import com.elminster.calc.ops.printer.impl.RPNCalculationModelPrinter;

public class Application {
  
  private static final String EXIT = "exit";
  
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    CalcululationContext ctx = new RPNCalculateContext();
    CalculationModel<BigDecimal> model = new RPNCalculatorModel();
    ctx.setModel(model);
    Calculator calc = new RPNCalculator();
    RPNCalculationModelPrinter printer = new RPNCalculationModelPrinter();
    
    try (Scanner sc = new Scanner(System.in)) {
      while(sc.hasNextLine()) {
        String line = sc.nextLine();
        if (EXIT.equals(line)) {
          System.exit(0);
        }
        SimpleCalculationRequest input = new SimpleCalculationRequest(line);
        SimpleCalculationResult result = (SimpleCalculationResult) calc.calculate(ctx, input);
        System.out.println(printer.print(result.getResult()));
      }
    }
  }
}
