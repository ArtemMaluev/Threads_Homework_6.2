package maluevArtem.calculation;

public class AreaLandPlots implements CalculationArea {

    @Override
    public long calculateArea(long length, long width) {
        return length * width;
    }
}
