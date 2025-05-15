class CPU {
    double price;

    CPU(double p) {
        price = p;
    }

    static class StaticFan {
        String type;

        StaticFan(String t) {
            type = t;
        }

        void showFan() {
            System.out.println("Fan Type: " + type);
        }
    }

    void cpuMethod() {
        class LocalCooler {
            int speed;

            LocalCooler(int s) {
                speed = s;
            }

            void showCooler() {
                System.out.println("Cooler Speed: " + speed + " RPM");
            }
        }

        LocalCooler cooler = new LocalCooler(1500);
        cooler.showCooler();
    }

    interface Power {
        void powerOn();
    }

    public static void main(String[] args) {
        CPU.StaticFan fan = new CPU.StaticFan("RGB Fan");
        fan.showFan();
        CPU cpu = new CPU(199.99);
        cpu.cpuMethod();
        Power powerSupply = new Power() {
            @Override
            public void powerOn() {
                System.out.println("Powering CPU at $" + cpu.price);
            }
        };
        powerSupply.powerOn();
    }
}