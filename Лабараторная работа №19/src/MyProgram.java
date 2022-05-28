import java.util.ArrayList;
import java.util.List;

interface Notifier{
     void addObserver(Observeres obs);
     void notifyObserver();
}
interface Observeres{
    void update(String first, String second, String third, String fourth);
}

public class MyProgram {
public static void main(String[] args){
    Goups gp = new Goups();
    Dashboard db = new Dashboard(gp);
    gp.changeData("Получено сообщение","Опубликована новая запись","Получено сообщение","Опубликована новая запись");
    gp.changeData("Опубликована новая запись","Получено сообщение","Опубликована новая запись","Получено сообщение");
}
}
class Goups implements Notifier{
    private List observers;
    private String firstGroup;
    private String secondGroup;
    private String thirdGroup;
    private String fourthGroup;
    public Goups() {
        observers = new ArrayList();
    }

    @Override
    public void addObserver(Observeres obs) {
        observers.add(obs);
    }



    @Override
    public void notifyObserver() {
        for(int i = 0; i < observers.size(); i++){
            Observeres obs = (Observeres)(observers.get(i));
            obs.update(firstGroup, secondGroup, thirdGroup, fourthGroup);
        }
    }
    public void changeData(String first, String second, String third, String fourth){
        this.firstGroup = first;
        this.secondGroup = second;
        this.thirdGroup = third;
        this.fourthGroup = fourth;
        notifyObserver();
    }
}
class Dashboard implements Observeres{
    private Notifier notifier;
    private String firstGroup;
    private String secondGroup;
    private String thirdGroup;
    private String fourthGroup;
    public Dashboard(Notifier notifier) {
        this.notifier = notifier;
        notifier.addObserver(this);
    }
    public void  update(String first, String second, String third, String fourth){
        this.firstGroup = first;
        this.secondGroup = second;
        this.thirdGroup = third;
        this.fourthGroup = fourth;
        show1();
        show2();
    }
    public void show1(){
        System.out.println("Оповещение от групп, на которые подписан первый пользователь: ");
        System.out.println("Первая группа: " + firstGroup + "; Вторая группа: " + secondGroup + "; Третья группа: " + thirdGroup);
        System.out.println();
    }
    public void show2(){
        System.out.println("Оповещение от групп, на которые подписан второй пользователь: ");
        System.out.println("Первая группа: " + firstGroup + "; Вторая группа: " + secondGroup + "; Третья группа: " + thirdGroup + "; Четвёртая группа: " + fourthGroup);
        System.out.println();
    }
}
