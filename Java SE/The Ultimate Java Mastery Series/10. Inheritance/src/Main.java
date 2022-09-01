public class Main {

    public static void main(String[] args) {
        var control = new TextBox();
        control.disable();
        System.out.println(control.toString());
        System.out.println(control.hashCode());
        System.out.println("----------------");

        var point1 = new Point(1, 2);
        var point2 = new Point(1, 2);
        System.out.println(point1.equals(point2));
        System.out.println(point1.hashCode());
        System.out.println(point2.hashCode());

        UIControl[] controls = {new TextBox(), new CheckBox()};
        for(var ctrl : controls)
            ctrl.render();
    }
}
