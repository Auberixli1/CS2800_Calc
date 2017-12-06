package views.ascii;

import java.util.function.Consumer;
import views.View;

public class AsciiView implements View {

  private String expression = "1+2";
  private String answer;

  private AsciiView(){

  }

  public String getExpression() {
    return expression;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public void addCalcObserver(Runnable runnable) {

  }

  @Override
  public void addTypeObserver(Consumer<Boolean> consumer) {

  }
}
