package maluevArtem.checkDeal;

public enum CorrectnessDeal {

    TRUE {
        public String action() {
            return "честно";
        }
    },
    FALSE {
        public String action() {
            return "нечестно";
        }
    };

    public abstract String action();
}
