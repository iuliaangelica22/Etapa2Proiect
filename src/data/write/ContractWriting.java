package data.write;

public final class ContractWriting {
    private final int consumerId;
    private final Integer price;
    private final Integer remainedContractMonths;

    public ContractWriting(final int consumerId, final Integer price,
                           final Integer remainedContractMonths) {
        this.consumerId = consumerId;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getRemainedContractMonths() {
        return remainedContractMonths;
    }
}
