package ly.generalassemb.drewmahrt.syncadapterexample;

public class StockResult {
    private String Name;
    private String Symbol;
    private String LastPrice;

    public StockResult(String name, String symbol, String lastPrice) {
        Name = name;
        Symbol = symbol;
        LastPrice = lastPrice;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getLastPrice() {
        return LastPrice;
    }

    public void setLastPrice(String lastPrice) {
        LastPrice = lastPrice;
    }
}
