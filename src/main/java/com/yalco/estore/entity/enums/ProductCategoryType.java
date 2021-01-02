package com.yalco.estore.entity.enums;

public enum ProductCategoryType {

    SMART_PHONES("smart-phones"),
    SMART_PHONE_CASES("smart-phone-cases"),
    SMART_PHONE_PROTECTORS("smart-phone-protectors"),
    SMART_PHONE_CHARGERS("smart-phone-chargers"),
    SMART_PHONE_CABLES("smart-phone-cables"),
    SMART_PHONE_POWERBANK("smart-phone-powerbank"),
    SMART_PHONE_OTHER_ACCESSORIES("smart-phone-other-accessories"),

    TABLETS("tablets"),
    TABLET_CASES("tablet-cases"),
    TABLET_CHARGES("tablet-charges"),
    TABLET_CABLES("tablet-cables"),
    TABLET_OTHER_ACCESSORIES("tablet-other-accessories"),


    LAPTOPS("laptops"),
    LAPTOP_BAGS("laptop-bags"),
    LAPTOP_BACKPACKS("laptop-backpacks"),
    LAPTOP_CABLES("laptop-cables"),
    LAPTOP_BATTERY("laptop-battery"),
    LAPTOP_OTHER_ACCESSORIES("laptop-other-accessories"),

    COMPUTERS("computers"),
    COMPUTER_PROCESSORS("processors"),
    VIDEO_CARDS("video-cards"),
    MOTHERBOARDS("motherboards"),
    RAM("ram"),
    HDD("hdd"),
    COMPUTER_CASES("computer-cases"),
    POWER_SUPPLIES("power-supplies"),
    SSD("ssd"),
    SOUND_CARDS("sound-cards"),
    PC_OTHER_COMPONENTS("pc-other-components"),

    MONITORS("monitors"),
    MONITOR_ACCESSORIES("monitor-accessories"),

    SOFTWARE_OFFICE("software-office"),
    SOFTWARE_DESKTOP("software-desktop"),
    SOFTWARE_OS("software-os"),
    SOFTWARE_ANTIVIRUS("software-antivirus"),
    SOFTWARE_OTHERS("software-others"),

    LASER_PRINTER("laser-printers"),
    INJECT_PRINTERS("inject-printers"),
    SCANNERS("scanners"),
    PRINTER_CONSUMABLES("printer-consumables"),

    PC_MOUSES("pc-mouses"),
    PC_KEYBOARDS("pc-keyboards"),
    ROUTERS("routers"),
    SWITCH("switch"),
    USB("usb"),
    EXTERNAL_HDD("external-hdd"),
    EXTERNAL_SSD("external-ssd"),
    PC_SPEAKERS("pc-speakers"),
    HEADPHONES("headphones"),
    WEB_CAMERA("web-camera"),

    TV("tv"),
    TV_ACCESSORIES("tv-accessories"),
    HOME_CINEMA("home-cinema"),
    AUDIO_SYSTEMS("audio-systems"),
    MULTIMEDIA_SYSTEMS("multimedia-systems"),
    SPEAKERS("speakers"),
    AUDIO_OTHERS("audio-others"),

    REFRIGERATORS("refrigerators"),
    COOLER_SHOWCASE("cooler-showcase"),
    FREEZERS("freezers"),
    FREEZER_CHESTS("freezer-chests"),

    LAUNDRY("laundry"),
    DRYERS("dryers"),

    DISHWASHERS("dishwashers"),

    COOKERS("cookers"),
    HOBS("hobs"),
    ELECTRIC_OVENS("electric-ovens"),
    MICROWAVE_OVENS("microwave-ovens"),
    HOODS("hoods"),

    AIR_CONDITIONERS("air-conditioners"),
    ELECTRIC_CONVERTERS("electric-converters"),
    FAN_STOVES("fan-stoves"),
    BOILERS("boilers"),
    ELECTRIC_FIREPLACES("electric-fireplaces"),
    ELECTRIC_RADIATORS("electric-radiators"),


    VACUUM_CLEANERS("vacuum-cleaners"),
    IRONS("irons"),
    SEWING_MACHINES("sewing-machines"),
    IRONING_BOARDS("ironing-boards"),

    ESPRESSO_MACHINES("espresso-machines"),
    COFFEE_MACHINES("coffee-machines"),
    COFFEE_GRINDERS("coffee-grinders"),
    JUICERS("juicers"),

    ELECTRIC_GRILLS("electric-grills"),
    DEEP_FRYERS("deep-fryers"),
    BAKERIES("bakeries"),
    MIXERS("mixers"),
    BLENDERS("blenders"),
    TOASTERS("toasters"),


    GAMING_PLAYSTATION("playstation"),
    GAMING_NINTENDO("nintendo"),
    GAMING_XBOX("xbox"),

    GAMES_CONSOLE("games-console"),
    GAMES_BOARD("games-board"),
    GAMES_PC("games-pc"),

    FITNESS_ERGOMETERS("fitness-ergometers"),
    FITNESS_TREADMILLS("fitness-treadmills"),
    FITNESS_ROWING_MACHINES("fitness-rowing-machines"),
    FITNESS_WEIGHTS("fitness-weights"),
    FITNESS_DUMBBELLS("fitness-dumbbells"),
    FITNESS_EQUIPMENT("fitness-equipment"),


    DSLR("dslr"),
    MIRRORLESS("mirrorless"),
    COMPACT_CAMERAS("compact-cameras"),
    INSTANT_CAMERAS("instant-cameras"),
    LENSES("lenses"),

    VIDEO_CAMERAS("video-cameras"),
    DRONES("drones"),
    SPORT_CAMERAS("sport-cameras"),
    VIDEO_OTHERS("video-others"),


    HOME_SOFAS("home-sofas"),
    HOME_BEDDING("home-bedding"),
    HOME_WARDROBES("home-wardrobes"),
    HOME_TABLES("home-tables"),
    HOME_ARMCHAIRS("home-armchairs"),
    HOME_CHAIRS("home-chairs"),
    HOME_CARPETS("home-carpets"),
    HOME_CURTAINS("home-curtains"),
    HOME_PILLOWS("home-pillows"),
    HOME_BLANKETS("home-blankets"),
    HOME_SLEEPWEAR("home-sleepwear"),


    AUTO_GPS("auto-gps"),
    AUTO_AUDIO("auto-audio"),
    AUTO_SPEAKERS("auto-speakers"),
    AUTO_VIDEORECORDER("auto-videorecorder"),
    AUTO_TYRES("auto-tyres"),


    BOOKS_ASTROLOGY("books-astrology"),
    BOOKS_ARCHITECTURE("books-architecture"),
    BOOKS_KIDS("books-kids"),
    BOOKS_DESIGN("books-design"),
    BOOKS_ART("books-art"),
    BOOKS_HISTORY("books-history"),
    BOOKS_IT("books-it"),
    BOOKS_CRIMINAL("books-criminal"),
    BOOKS_MARKETING("books-marketing"),
    BOOKS_MATH("books-math"),
    BOOKS_MEDICINE("books-medicine"),
    BOOKS_MANAGEMENT("books-management"),
    BOOKS_SCIENCE("books-science"),
    BOOKS_PSYCHOLOGY("books-psychology"),
    BOOKS_CLASSICS("books-classics"),
    BOOKS_FANTASY("books-fantasy"),
    BOOKS_FINANCE("books-finance");

    private final String name;

    ProductCategoryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ProductCategoryType getProductCategoryTypeByName(String name) {
        switch (name) {
            case "smart-phones":
                return SMART_PHONES;
            case "smart-phone-cases":
                return SMART_PHONE_CASES;
            case "smart-phone-protectors":
                return SMART_PHONE_PROTECTORS;
            case "smart-phone-chargers":
                return SMART_PHONE_CHARGERS;
            case "smart-phone-cables":
                return SMART_PHONE_CABLES;
            case "smart-phone-powerbank":
                return SMART_PHONE_POWERBANK;
            case "smart-phone-other-accessories":
                return SMART_PHONE_OTHER_ACCESSORIES;
            case "tablets":
                return TABLETS;
            case "tablet-cases":
                return TABLET_CASES;
            case "tablet-charges":
                return TABLET_CHARGES;
            case "tablet-cables":
                return TABLET_CABLES;
            case "tablet-other-accessories":
                return TABLET_OTHER_ACCESSORIES;
            case "laptops":
                return LAPTOPS;
            case "laptop-bags":
                return LAPTOP_BAGS;
            case "laptop-backpacks":
                return LAPTOP_BACKPACKS;
            case "laptop-cables":
                return LAPTOP_CABLES;
            case "laptop-battery":
                return LAPTOP_BATTERY;
            case "laptop-other-accessories":
                return LAPTOP_OTHER_ACCESSORIES;
            case "computers":
                return COMPUTERS;
            case "processors":
                return COMPUTER_PROCESSORS;
            case "video-cards":
                return VIDEO_CARDS;
            case "motherboards":
                return MOTHERBOARDS;
            case "ram":
                return RAM;
            case "hdd":
                return HDD;
            case "computer-cases":
                return COMPUTER_CASES;
            case "power-supplies":
                return POWER_SUPPLIES;
            case "ssd":
                return SSD;
            case "sound-cards":
                return SOUND_CARDS;
            case "pc-other-components":
                return PC_OTHER_COMPONENTS;
            case "monitors":
                return MONITORS;
            case "monitor-accessories":
                return MONITOR_ACCESSORIES;
            case "software-office":
                return SOFTWARE_OFFICE;
            case "software-desktop":
                return SOFTWARE_DESKTOP;
            case "software-os":
                return SOFTWARE_OS;
            case "software-antivirus":
                return SOFTWARE_ANTIVIRUS;
            case "software-others":
                return SOFTWARE_OTHERS;
            case "laser-printers":
                return LASER_PRINTER;
            case "inject-printers":
                return INJECT_PRINTERS;
            case "scanners":
                return SCANNERS;
            case "printer-consumables":
                return PRINTER_CONSUMABLES;
            case "pc-mouses":
                return PC_MOUSES;
            case "pc-keyboards":
                return PC_KEYBOARDS;
            case "routers":
                return ROUTERS;
            case "switch":
                return SWITCH;
            case "usb":
                return USB;
            case "external-hdd":
                return EXTERNAL_HDD;
            case "external-ssd":
                return EXTERNAL_SSD;
            case "pc-speakers":
                return PC_SPEAKERS;
            case "headphones":
                return HEADPHONES;
            case "web-camera":
                return WEB_CAMERA;
            case "tv":
                return TV;
            case "tv-accessories":
                return TV_ACCESSORIES;
            case "home-cinema":
                return HOME_CINEMA;
            case "audio-systems":
                return AUDIO_SYSTEMS;
            case "multimedia-systems":
                return MULTIMEDIA_SYSTEMS;
            case "speakers":
                return SPEAKERS;
            case "audio-others":
                return AUDIO_OTHERS;
            case "refrigerators":
                return REFRIGERATORS;
            case "cooler-showcase":
                return COOLER_SHOWCASE;
            case "freezers":
                return FREEZERS;
            case "freezer-chests":
                return FREEZER_CHESTS;
            case "laundry":
                return LAUNDRY;
            case "dryers":
                return DRYERS;
            case "dishwashers":
                return DISHWASHERS;
            case "cookers":
                return COOKERS;
            case "hobs":
                return HOBS;
            case "electric-ovens":
                return ELECTRIC_OVENS;
            case "microwave-ovens":
                return MICROWAVE_OVENS;
            case "hoods":
                return HOODS;
            case "air-conditioners":
                return AIR_CONDITIONERS;
            case "electric-converters":
                return ELECTRIC_CONVERTERS;
            case "fan-stoves":
                return FAN_STOVES;
            case "boilers":
                return BOILERS;
            case "electric-fireplaces":
                return ELECTRIC_FIREPLACES;
            case "electric-radiators":
                return ELECTRIC_RADIATORS;
            case "vacuum-cleaners":
                return VACUUM_CLEANERS;
            case "irons":
                return IRONS;
            case "sewing-machines":
                return SEWING_MACHINES;
            case "ironing-boards":
                return IRONING_BOARDS;
            case "espresso-machines":
                return ESPRESSO_MACHINES;
            case "coffee-machines":
                return COFFEE_MACHINES;
            case "coffee-grinders":
                return COFFEE_GRINDERS;
            case "juicers":
                return JUICERS;
            case "electric-grills":
                return ELECTRIC_GRILLS;
            case "deep-fryers":
                return DEEP_FRYERS;
            case "bakeries":
                return BAKERIES;
            case "mixers":
                return MIXERS;
            case "blenders":
                return BLENDERS;
            case "toasters":
                return TOASTERS;
            case "playstation":
                return GAMING_PLAYSTATION;
            case "nintendo":
                return GAMING_NINTENDO;
            case "xbox":
                return GAMING_XBOX;
            case "games-console":
                return GAMES_CONSOLE;
            case "games-board":
                return GAMES_BOARD;
            case "games-pc":
                return GAMES_PC;
            case "fitness-ergometers":
                return FITNESS_ERGOMETERS;
            case "fitness-treadmills":
                return FITNESS_TREADMILLS;
            case "fitness-rowing-machines":
                return FITNESS_ROWING_MACHINES;
            case "fitness-weights":
                return FITNESS_WEIGHTS;
            case "fitness-dumbbells":
                return FITNESS_DUMBBELLS;
            case "fitness-equipment":
                return FITNESS_EQUIPMENT;
            case "dslr":
                return DSLR;
            case "mirrorless":
                return MIRRORLESS;
            case "compact-cameras":
                return COMPACT_CAMERAS;
            case "instant-cameras":
                return INSTANT_CAMERAS;
            case "lenses":
                return LENSES;
            case "video-cameras":
                return VIDEO_CAMERAS;
            case "drones":
                return DRONES;
            case "sport-cameras":
                return SPORT_CAMERAS;
            case "video-others":
                return VIDEO_OTHERS;
            case "home-sofas":
                return HOME_SOFAS;
            case "home-bedding":
                return HOME_BEDDING;
            case "home-wardrobes":
                return HOME_WARDROBES;
            case "home-tables":
                return HOME_TABLES;
            case "home-armchairs":
                return HOME_ARMCHAIRS;
            case "home-chairs":
                return HOME_CHAIRS;
            case "home-carpets":
                return HOME_CARPETS;
            case "home-curtains":
                return HOME_CURTAINS;
            case "home-pillows":
                return HOME_PILLOWS;
            case "home-blankets":
                return HOME_BLANKETS;
            case "home-sleepwear":
                return HOME_SLEEPWEAR;
            case "auto-gps":
                return AUTO_GPS;
            case "auto-audio":
                return AUTO_AUDIO;
            case "auto-speakers":
                return AUTO_SPEAKERS;
            case "auto-videorecorder":
                return AUTO_VIDEORECORDER;
            case "auto-tyres":
                return AUTO_TYRES;
            case "books-astrology":
                return BOOKS_ASTROLOGY;
            case "books-architecture":
                return BOOKS_ARCHITECTURE;
            case "books-kids":
                return BOOKS_KIDS;
            case "books-design":
                return BOOKS_DESIGN;
            case "books-art":
                return BOOKS_ART;
            case "books-history":
                return BOOKS_HISTORY;
            case "books-it":
                return BOOKS_IT;
            case "books-criminal":
                return BOOKS_CRIMINAL;
            case "books-marketing":
                return BOOKS_MARKETING;
            case "books-math":
                return BOOKS_MATH;
            case "books-medicine":
                return BOOKS_MEDICINE;
            case "books-management":
                return BOOKS_MANAGEMENT;
            case "books-science":
                return BOOKS_SCIENCE;
            case "books-psychology":
                return BOOKS_PSYCHOLOGY;
            case "books-classics":
                return BOOKS_CLASSICS;
            case "books-fantasy":
                return BOOKS_FANTASY;
            case "books-finance":
                return BOOKS_FINANCE;
            default:
                throw new IllegalArgumentException("Category name ["
                        + name + "] not supported");
        }
    }

}
