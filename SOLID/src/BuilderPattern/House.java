package BuilderPattern;


public class House {
    private String walls;
    private String roof;
    private boolean hasGarage;
    private boolean hasSwimmingPool;

    // Private constructor - built by the Builder
    private House(Builder builder) {
        this.walls = builder.walls;
        this.roof = builder.roof;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
    }

    public void showDetails() {
        System.out.println("House with: " + walls + ", " + roof +
                ", Garage: " + hasGarage + ", Swimming Pool: " + hasSwimmingPool);
    }

    // Builder (Static Inner Class)
    public static class Builder {
        private String walls;
        private String roof;
        private boolean hasGarage;
        private boolean hasSwimmingPool;

        public Builder setWalls(String walls) {
            this.walls = walls;
            return this;
        }

        public Builder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public Builder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public Builder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
