package org.example.HomeWork_7;

public class DZ7 {
    public enum SolarSystem {
        Mercury (0,2439,null),
        Venus (50,6051,Mercury),
        Earth (41,6371,Venus),
        Mars (48,3389,Earth),
        Jupiter(550,69911,Mars),
        Saturn(650,58232,Jupiter),
        Uranus(1620,24622,Saturn),
        Neptune(1620,24622,Uranus);

        private int order;
        private int distanceFromPrevious;
        private int distanceFromSun;
        private int radius;
        private SolarSystem previousPlanet;
        private SolarSystem nextPlanet;

        SolarSystem(int distanceFromPrevious, int radius, SolarSystem previousPlanet){
            this.order = previousPlanet == null ? 1 : previousPlanet.getOrder() + 1;
            this.distanceFromPrevious = distanceFromPrevious;
            this.radius = radius;
            this.previousPlanet = previousPlanet;
            this.distanceFromSun = previousPlanet == null ? 0 : previousPlanet.getDistanceFromSun() + distanceFromPrevious;

            if (previousPlanet != null){
                previousPlanet.setNextPlanet(this);
            }
        }
        public int getOrder(){
            return order;
        }
        public int getDistanceFromPrevious(){
            return distanceFromPrevious;
        }
        public int getDistanceFromSun(){
            return distanceFromSun;
        }
        public int getRadius(){
            return radius;
        }
        public SolarSystem getPreviousPlanet(){
            return previousPlanet;
        }
        public SolarSystem getNextPlanet(){
            return nextPlanet;
        }
        private void setNextPlanet(SolarSystem nextPlanet){
            this.nextPlanet = nextPlanet;
        }

        public static void main(String[] args) {
            for (SolarSystem planet : SolarSystem.values()){
                    System.out.println("Planet: " + planet.name());
                    System.out.println("Order: " + planet.getOrder());
                    System.out.println("Distance from previous: " + planet.getDistanceFromPrevious());
                    System.out.println("Distance from Sun: " + planet.getDistanceFromSun());
                    System.out.println("Radius: " + planet.getRadius());
                    System.out.println("Previous planet: " + (planet.getPreviousPlanet() != null ? planet.getPreviousPlanet().name() : "None"));
                    System.out.println("Next planet: " + (planet.getNextPlanet() != null ? planet.getNextPlanet().name() : "None"));System.out.println();
            }
        }
    }
}
