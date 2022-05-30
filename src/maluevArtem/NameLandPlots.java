package maluevArtem;

public enum NameLandPlots {

    FOREST {
        public String action() {
            return "\"ЛЕСОК\"";
        }
    },
    FIELD {
        public String action() {
            return "\"ПОЛЕ\"";
        }
    },
    RIVER {
        public String action() {
            return "\"РЕЧКА\"";
        }
    },
    APIARY {
        public String action() {
            return "\"ПАСЕКА\"";
        }
    },
    MANOR {
        public String action() {
            return "\"УСАДЬБА\"";
        }
    };

    public abstract String action();
}
