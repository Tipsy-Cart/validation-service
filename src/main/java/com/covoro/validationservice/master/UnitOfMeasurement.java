package com.covoro.validationservice.master;

public enum UnitOfMeasurement {

    GROUP("10", "group - A unit of count defining the number of groups (group: set of items classified together)."),
    OUTFIT("11", "outfit - A unit of count defining the number of outfits (a complete set of equipment/materials/objects used for a specific purpose)."),
    RATION("13", "ration - A unit of count defining the number of rations (a single portion of provisions)."),
    SHOT("14", "shot - A unit of liquid measure, especially related to spirits."),
    STICK_MILITARY("15", "stick, military - A unit of count defining the number of military sticks (bombs or paratroops released in rapid succession)."),
    TWENTY_FOOT_CONTAINER("20", "twenty foot container - A unit of count defining the number of 20-foot shipping containers."),
    FORTY_FOOT_CONTAINER("21", "forty foot container - A unit of count defining the number of 40-foot shipping containers."),
    DECILITRE_PER_GRAM("22", "decilitre per gram"),
    GRAM_PER_CUBIC_CENTIMETRE("23", "gram per cubic centimetre"),
    THEORETICAL_POUND("24", "theoretical pound - Expected mass expressed as pounds."),
    GRAM_PER_SQUARE_CENTIMETRE("25", "gram per square centimetre"),
    THEORETICAL_TON("27", "theoretical ton - Expected mass expressed as tons."),
    KILOGRAM_PER_SQUARE_METRE("28", "kilogram per square metre"),
    KILOPASCAL_SQUARE_METRE_PER_GRAM("33", "kilopascal square metre per gram"),
    KILOPASCAL_PER_MILLIMETRE("34", "kilopascal per millimetre"),
    MILLILITRE_PER_SQUARE_CENTIMETRE_SECOND("35", "millilitre per square centimetre second"),
    OUNCE_PER_SQUARE_FOOT("37", "ounce per square foot"),
    OUNCE_PER_SQUARE_FOOT_PER_0_01_INCH("38", "ounce per square foot per 0.01 inch"),
    MILLILITRE_PER_SECOND("40", "millilitre per second"),
    MILLILITRE_PER_MINUTE("41", "millilitre per minute"),
    SITAS("56", "sitas - Area for tin plate equal to 100 square metres."),
    MESH("57", "mesh - Number of strands per inch in woven product."),
    NET_KILOGRAM("58", "net kilogram - Total number of kilograms after deductions."),
    PART_PER_MILLION("59", "part per million (10⁻⁶)"),
    PERCENT_WEIGHT("60", "percent weight (10⁻²)"),
    PART_PER_BILLION("61", "part per billion (10⁻⁹)"),
    MILLIPASCAL("74", "millipascal"),
    MILLI_INCH("77", "milli-inch"),
    POUND_PER_SQUARE_INCH_ABS("80", "pound per square inch absolute"),
    HENRY("81", "henry"),
    FOOT_POUND_FORCE("85", "foot pound-force"),
    POUND_PER_CUBIC_FOOT("87", "pound per cubic foot"),
    POISE("89", "poise");

    final String code;
    final String description;

    UnitOfMeasurement(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
