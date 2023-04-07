package com.playko.store.infrastructure.out.jpa.entity;

import com.playko.store.domain.model.ItemModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    private Double quantityItem;

    private Double priceItem;

    private Long productId;
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    public static List<ItemEntity> ofItemModelList(List<ItemModel> itemModelList) {
        List<ItemEntity> itemEntityList = new ArrayList<>();
        for (ItemModel itemModel : itemModelList) {
            itemEntityList.add(ItemEntity.ofItemModel(itemModel));
        }
        return itemEntityList;
    }

    public static ItemEntity ofItemModel(ItemModel itemModel) {
        return ItemEntity.builder()
                .idItem(itemModel.getIdItem())
                .quantityItem(itemModel.getQuantityItem())
                .priceItem(itemModel.getPriceItem())
                .productId(itemModel.getProductId())
                .build();
    }
}
