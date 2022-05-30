package maluevArtem.generateDeals;

import maluevArtem.NameLandPlots;
import maluevArtem.deal.Deal;

import java.util.HashMap;
import java.util.Map;

public class GenerateDeals {

    private final Map<NameLandPlots, Long> listPricesDeals;
    private final Map<NameLandPlots, long[]> listLandPlots;
    private final Map<NameLandPlots, Deal> listDeals;

    public GenerateDeals(Map<NameLandPlots, Long> listPricesDeals, Map<NameLandPlots, long[]> listLandPlots) {
        listDeals = new HashMap<>();
        this.listPricesDeals = listPricesDeals;
        this.listLandPlots = listLandPlots;
    }

    public Map<NameLandPlots, Deal> getListDeals() {
        return listDeals;
    }

    // рекурсия вместо цикла
    public void generateDeals(int recursionCounter) {
        if (recursionCounter < listPricesDeals.size()) {
            Deal deal = new Deal(listLandPlots.get(NameLandPlots.values()[recursionCounter]),
                    listPricesDeals.get(NameLandPlots.values()[recursionCounter]));
            listDeals.put(NameLandPlots.values()[recursionCounter], deal);
            recursionCounter++;
            generateDeals(recursionCounter);
        }
    }

    public void outputMapList(Map<NameLandPlots, Deal> list) {
        System.out.println("Предложенные цены на участки земли:");
        for (Map.Entry<NameLandPlots, Deal> item : list.entrySet()) {
            System.out.println("Цена на участок " + item.getKey().action() + ": " + item.getValue().getCostLandPlots() + " руб.");
        }
        System.out.println();
    }
}
