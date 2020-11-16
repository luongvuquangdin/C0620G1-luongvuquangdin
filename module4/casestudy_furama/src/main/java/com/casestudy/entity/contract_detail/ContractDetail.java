package com.casestudy.entity.contract_detail;

import com.casestudy.entity.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    Integer contractDetailId;
    @Column(name = "quantity")
    @NotNull
    @Min(value = 1, message = "Quantity > 0 and quantity is positive integer")
    Integer quantity;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    AttachOfService attachService;

    public ContractDetail() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachOfService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachOfService attachService) {
        this.attachService = attachService;
    }
}
