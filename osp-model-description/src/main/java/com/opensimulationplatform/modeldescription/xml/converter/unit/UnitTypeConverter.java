package com.opensimulationplatform.modeldescription.xml.converter.unit;

import com.opensimulationplatform.core.model.modeldescription.Unit;
import com.opensimulationplatform.modeldescription.xml.converter.Converter;
import com.opensimulationplatform.modeldescription.xml.converter.ConverterContext;
import com.opensimulationplatform.modeldescription.xml.model.Fmi2Unit;
import com.opensimulationplatform.modeldescription.xml.model.UnitType;

import static com.opensimulationplatform.core.model.modeldescription.Unit.Exponent.*;

public class UnitTypeConverter extends Converter<UnitType, Unit> {
  public UnitTypeConverter(ConverterContext converterContext) {
    super(converterContext);
  }

  @Override
  public Unit convert(UnitType unitType) {
    Unit unit = new Unit();
    unit.setName(unitType.getName());

    Fmi2Unit.BaseUnit baseUnit = unitType.getBaseUnit();

    unit.setFactor(baseUnit.getFactor());
    unit.setOffset(baseUnit.getOffset());

    unit.setExponent(KILOGRAM, baseUnit.getKg());
    unit.setExponent(METER, baseUnit.getM());
    unit.setExponent(SECOND, baseUnit.getS());
    unit.setExponent(AMPERE, baseUnit.getA());
    unit.setExponent(KELVIN, baseUnit.getK());
    unit.setExponent(MOL, baseUnit.getMol());
    unit.setExponent(CANDELA, baseUnit.getCd());
    unit.setExponent(RADIAN, baseUnit.getRad());

    return unit;
  }
}
