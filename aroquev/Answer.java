import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Answer {

  private int id;
  private int questionId;
  private String type;
  private String answerText;

  static Answer of(int id, int questionId, String type, String answerText) {
    return new AutoVlaue_Answer(id, questionId, type, answerText);
  }

  public abstract int id();
  public abstract int questionId();
  public abstract String type();
  public abstract String answerText();
  
}


public interface AnswerDao {
  public List<Answer> getAllAnswers();
  public Answer getAnswer(int id);
  public void updateAnswer(Answer answer);
  public void deleteAnswer(Answer answer);
}

public class AnswerDaoImpl implements AnswerDao {
  //list is working as a database
  List<Answer> answers;

  public AnswerDaoImpl() {
    answers = new ArrayList<Answer>();
  }

  @Override
  public List<Answer> getAllAnswers(int id) {
    return answers;
  }

  @Override
  public Answer getAnswer(int id) {
    return answers.get(id);
  } 

  @Override
  public void updateAnswer(Answer answer) {
    answers.get(answer.getId()).setAnswerText(answer.getAnswerText());
  }
}

public class DaoPatternDemo {
  public static void main(String[] args) {
    AnswerDao answerDao = new AnswerDaoImpl();

    // Do test stuff here

  }
}
