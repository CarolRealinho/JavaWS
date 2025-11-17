public class MultiCatch {
    public void foo() {
        try {
        // ...
        } catch(IllegalArgumentException e1) {
        // ...
        } catch(RuntimeException e2) {
        // ...
        }
    }

    public void bar() {
        try {
        // ...
        } catch(IllegalStateException e1) {
        // ...
        } catch(IllegalArgumentException e2) {
        // ...
        }
    }

    public void baz() {
        try {
        // ...
        } catch(IllegalArgumentException e1) {
        // ...
        } catch(IllegalStateException e2) {
        // ...
        }
    }

    public void qux() {
        try {
        // ...
        } catch(RuntimeException e1) {
        // ...
        } catch(Exception e2) {
        // ...
        }
    }
}
