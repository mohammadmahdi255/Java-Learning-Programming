public abstract class UIControl {
    private boolean isEnabled;

    public UIControl() {
        enable();
        System.out.println("UIControl");
    }

    public abstract void render();

    public final void enable() {
        isEnabled = true;
    }

    public void disable() {
        isEnabled = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
