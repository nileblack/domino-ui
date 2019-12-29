package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.utils.ElementUtil;

public class ShortBox extends NumberBox<ShortBox, Short> {

    public static ShortBox create() {
        return new ShortBox();
    }

    public static ShortBox create(String label) {
        return new ShortBox(label);
    }

    public ShortBox() {
        this("");
    }

    public ShortBox(String label) {
        super(label);
        ElementUtil.numbersOnly(this);
    }

    @Override
    protected void clearValue() {
        value((short) 0);
    }

    @Override
    protected Short parseValue(String value) {
        double dValue = getNumberFormat().parse(value);
        double maxShort=new Double(getMaxValue());

        if(dValue > maxShort){
            throw new NumberFormatException("Exceeded maximum value");
        }
        return new Double(dValue).shortValue();
    }

    @Override
    protected Short defaultMaxValue() {
        return Short.MAX_VALUE;
    }

    @Override
    protected Short defaultMinValue() {
        return Short.MIN_VALUE;
    }

    @Override
    protected boolean isExceedMaxValue(Short maxValue, Short value) {
        return value > maxValue;
    }

    @Override
    protected boolean isLowerThanMinValue(Short minValue, Short value) {
        return value < minValue;
    }
}
