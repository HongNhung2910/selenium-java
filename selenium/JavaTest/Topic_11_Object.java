package JavaTest;

public class Topic_11_Object {
    int ID;
    String name;
    int Age;
    int score;

    public Topic_11_Object(int ID, String name, int Age, int score){
    this.ID=ID;
    this.name=name;
    this.Age=Age;
    this.score=score;
    }

    public void display(){
        System.out.println("SBD "+ID);
        System.out.println("Tên "+name);
        System.out.println("Tuổi "+Age);
        System.out.println("Điểm "+score);
    }

    public static void main(String[] args){
        Topic_11_Object[] students= new Topic_11_Object[4];
        students[0] = new Topic_11_Object(001,"An",18,9);
        students[1] = new Topic_11_Object(002,"Bình",18,10);
        students[2] = new Topic_11_Object(003,"Cường",18,8);
        students[3] = new Topic_11_Object(004,"Dũng",18,10);
        for (int i=0; i< 4;i++){
            students[i].display();
        }
    }

}
