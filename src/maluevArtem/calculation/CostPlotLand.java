package maluevArtem.calculation;

import maluevArtem.calculation.CalculationCostPlotLand;

public class CostPlotLand implements CalculationCostPlotLand {

    @Override
    public long calculationCost(long area, long priceSquareMeter) {
        return area * priceSquareMeter;
    }
}
