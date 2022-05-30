package maluevArtem;

import maluevArtem.checkDeal.CheckDeal;
import maluevArtem.generateDeals.GenerateDeals;
import maluevArtem.recommendedPrice.RecommendedPrice;

import java.util.*;

public class Main {

    static final int RECURSION_COUNTER = 0;

    static final int RECOMMEND_PRICE_SQUARE_METER = 500;

    public static void main(String[] args) {

        // Список участков земли с размерами
        Map<NameLandPlots, long[]> listLandPlots = new HashMap<>();
        listLandPlots.put(NameLandPlots.FOREST, new long[]{100, 200});
        listLandPlots.put(NameLandPlots.FIELD, new long[]{200, 300});
        listLandPlots.put(NameLandPlots.RIVER, new long[]{400, 400});
        listLandPlots.put(NameLandPlots.APIARY, new long[]{400, 500});
        listLandPlots.put(NameLandPlots.MANOR, new long[]{800, 800});

        // Список цен за кв.м. предлагаемых за продажу участков
        Map<NameLandPlots, Long> listPricesDeals = new HashMap<>();
        listPricesDeals.put(NameLandPlots.FOREST, 500L);
        listPricesDeals.put(NameLandPlots.FIELD, 490L);
        listPricesDeals.put(NameLandPlots.RIVER, 500L);
        listPricesDeals.put(NameLandPlots.APIARY, 400L);
        listPricesDeals.put(NameLandPlots.MANOR, 510L);

        RecommendedPrice recommendedPrice = new RecommendedPrice(RECOMMEND_PRICE_SQUARE_METER, listLandPlots);
        recommendedPrice.calculationRecommendedPrice(RECURSION_COUNTER);
        recommendedPrice.outputMapList(recommendedPrice.getListRecommendedPrice());

        GenerateDeals generateDeals = new GenerateDeals(listPricesDeals, listLandPlots);
        generateDeals.generateDeals(RECURSION_COUNTER);
        generateDeals.outputMapList(generateDeals.getListDeals());

        CheckDeal dealMaker = new CheckDeal(recommendedPrice.getListRecommendedPrice(), generateDeals.getListDeals());
        dealMaker.checkDeals(RECURSION_COUNTER);
        dealMaker.outputList(dealMaker.getListDeals());

    }
}