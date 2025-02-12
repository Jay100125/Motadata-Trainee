package oop;

class User {
    String name = "User";
    void saveWebLink() {
        System.out.println("User: Saving web link...");
    }

    void saveMovie() {
        System.out.println("User: Saving movie...");
    }

    void saveBook() {
        System.out.println("User: Saving book...");
    }

    void rateBookmark() {
        System.out.println("User: Rating bookmark...");
    }

    void postAReview() {
        System.out.println("User: Posting a review...");
    }
    void instanceMethod(int a)
    {
        System.out.println("user: instance method");
    }

    static void printSomething() {
        System.out.println("User: Printing something...");
    }

    void printName() {
        System.out.println(name);
    }
}

class Staff extends User {
    Staff(){
        name = "Staff";
    }
    @Override
    void postAReview() {
        System.out.println("Staff: Posting a detailed review...");
    }

    void instanceMethod(double a) {
        System.out.println("Staff: instance method");
    }
    static void printSomething() {
        System.out.println("staff: Printing something...");
    }
    void printName() {
        System.out.println(name);
    }
}

class EmailAdmin extends Staff {
    void handleEmail() {
        System.out.println("EmailAdmin: Handling email...");
    }
}

class Editor extends Staff {
    Editor(){
        name = "Editor";
    }
    void approveReview() {
        System.out.println("Editor: Approving review...");
    }

    void rejectReview() {
        System.out.println("Editor: Rejecting review...");
    }
    static void printSomething() {
        System.out.println("editor: Printing something...");
    }
//    void printName() {
//        System.out.println(name);
//    }
}

class ChiefEditor extends Editor {
    void updateHomepage() {
        System.out.println("ChiefEditor: Updating homepage...");
    }
    static void printSomething() {
        System.out.println("chief: Printing something...");
    }
}

public class Testing {
//    public void printUserType(User u) {
//        u.printUserType();
//    }

    public void approveReview(Staff s) {
//        s.approveReview();
        ((Editor) s).approveReview();
//        if (s instanceof Editor) {
//            s.saveWebLink();
//            ((Editor) s).approveReview();
//
//        } else {
//            System.out.println("Invalid object passed!!");
//        }
    }
    public static void main(String[] args) {
//        User editor = new Editor();
//        editor.postAReview();
//        ((Editor)editor).approveReview();
//        editor.postAReview();
//        editor.saveWebLink();
//        Testing t = new Testing();
//        t.printUserType(user);

//        Staff staff = new Editor();
//        staff.postAReview();
//        ((Editor)staff).approveReview();

//        Testing t = new Testing();
//      t.approveReview(new Staff());
//        t.approveReview(new Editor());
//        t.approveReview(new ChiefEditor());
//        t.approveReview(new EmailAdmin());
//        User user = new Staff();
//        User e = new Editor();
//        e.postAReview();
//        //e.approveReview();
//        user.postAReview();
//        user.saveWebLink();

//        User user = new Editor();
//        System.out.println(user.getClass().getSimpleName());
//        System.out.println(user instanceof Staff);
//        System.out.println(user instanceof Editor);
//        System.out.println(user instanceof ChiefEditor);
//        System.out.println(user instanceof EmailAdmin);
//        System.out.println(user instanceof User);
//        System.out.println();
//        Staff staff = new Editor();
//        System.out.println(staff instanceof Staff);
//        System.out.println(staff instanceof Editor);
//        System.out.println(staff instanceof ChiefEditor);
//        System.out.println(staff instanceof EmailAdmin);
//        System.out.println(staff instanceof User);
//        System.out.println();
//        Staff s = new Staff();
//        System.out.println(s instanceof Staff);
//        System.out.println(s instanceof Editor);

//        User u = new Staff();
//        u.instanceMethod(1);

        Editor s = new Editor();
//        System.out.println(s.getClass());
//        s.printName();
//        System.out.println(s.name);
        s.printSomething();

    }
}
