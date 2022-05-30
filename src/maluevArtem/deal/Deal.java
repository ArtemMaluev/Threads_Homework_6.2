package maluevArtem.deal;

import maluevArtem.calculation.AreaLandPlots;
import maluevArtem.calculation.CostPlotLand;

public class Deal {

    private final AreaLandPlots areaLandPlots;
    private final CostPlotLand costPlotLand;
    private final long[] landPlots;
    private final long priceSquareMeter;

    private long area;
    private long costLandPlots;

    public Deal(long[] landPlots, long priceSquareMeter) {
        areaLandPlots = new AreaLandPlots();
        costPlotLand = new CostPlotLand();
        this.landPlots = landPlots;
        this.priceSquareMeter = priceSquareMeter;

        calculateAreaPlotLand();
        calculationCostPlotLand();
    }

    public long getCostLandPlots() {
        return costLandPlots;
    }

    private void calculateAreaPlotLand() {
        area = areaLandPlots.calculateArea(landPlots[0], landPlots[1]);
    }

    public void calculationCostPlotLand() {
        costLandPlots = costPlotLand.calculationCost(area, priceSquareMeter);
    }
}
