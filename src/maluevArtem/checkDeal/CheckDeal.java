package maluevArtem.checkDeal;

import maluevArtem.deal.Deal;
import maluevArtem.NameLandPlots;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckDeal {

    private final Map<NameLandPlots, Long> listRecommendedPrice;
    private final Map<NameLandPlots, Deal> listDeals;
    private final List<String> listVerificationResults;

    public CheckDeal(Map<NameLandPlots, Long> listRecommendedPrice, Map<NameLandPlots, Deal> listDeals) {
        listVerificationResults = new ArrayList<>();
        this.listRecommendedPrice = listRecommendedPrice;
        this.listDeals = listDeals;
    }

    public List<String> getListVerificationResults() {
        return listVerificationResults;
    }

    public Map<NameLandPlots, Deal> getListDeals() {
        return listDeals;
    }

    // рекурсия вместо цикла
    public void checkDeals(int recursionCounter) {
        if (recursionCounter < listDeals.size()) {
            if (listRecommendedPrice.get(NameLandPlots.values()[recursionCounter])
                    <= listDeals.get(NameLandPlots.values()[recursionCounter]).getCostLandPlots()) {
                CorrectnessDeal c = CorrectnessDeal.TRUE;
                listVerificationResults.add(c.action());
            } else {
                CorrectnessDeal c = CorrectnessDeal.FALSE;
                listVerificationResults.add(c.action());
            }
            recursionCounter++;
            checkDeals(recursionCounter);
        }
    }

    public void outputList(Map<NameLandPlots, Deal> list) {
        System.out.println("Результат проверки:");
        int i = 0;
        for (Map.Entry<NameLandPlots, Deal> item : list.entrySet()) {
            System.out.println("Сделка на участок " + item.getKey().action() + " - " + listVerificationResults.get(i));
            i++;
        }
    }
}
