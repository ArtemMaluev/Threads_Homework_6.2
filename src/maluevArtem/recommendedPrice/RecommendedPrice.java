package maluevArtem.recommendedPrice;

import maluevArtem.NameLandPlots;
import maluevArtem.calculation.AreaLandPlots;

import java.util.HashMap;
import java.util.Map;

public class RecommendedPrice {

    private final int recommendPriceSquareMeter;
    private final Map<NameLandPlots, long[]> listLandPlots;
    private final AreaLandPlots areaLandPlots;
    private final Map<NameLandPlots, Long> listRecommendedPrice;

    public RecommendedPrice(int priceSquareMeter, Map<NameLandPlots, long[]> listLandPlots) {
        listRecommendedPrice = new HashMap<>();
        areaLandPlots = new AreaLandPlots();
        this.recommendPriceSquareMeter = priceSquareMeter;
        this.listLandPlots = listLandPlots;
    }

    public Map<NameLandPlots, Long> getListRecommendedPrice() {
        return listRecommendedPrice;
    }

    // рекурсия вместо цикла
    public void calculationRecommendedPrice(int recursionCounter) {
        if (recursionCounter < listLandPlots.size()) {
            listRecommendedPrice.put(NameLandPlots.values()[recursionCounter],
                    areaLandPlots.calculateArea(listLandPlots.get(NameLandPlots.values()[recursionCounter])[0],
                            listLandPlots.get(NameLandPlots.values()[recursionCounter])[1])
                            * recommendPriceSquareMeter);
            recursionCounter++;
            calculationRecommendedPrice(recursionCounter);
        }
    }

    public void outputMapList(Map<NameLandPlots, Long> list) {
        System.out.println("Рекомендуемые цены на участки земли:");
        for (Map.Entry<NameLandPlots, Long> item : list.entrySet()) {
            System.out.println("Цена на участок " + item.getKey().action() + ": " + item.getValue() + " руб.");
        }
        System.out.println();
    }
}
