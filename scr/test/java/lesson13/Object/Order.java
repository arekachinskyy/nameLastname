package lesson13.Object;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter

public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

}

//{
//        "id": 0,
//        "petId": 0,
//        "quantity": 0,
//        "shipDate": "2021-12-13T20:41:48.594Z",
//        "status": "placed",
//        "complete": true
//        }
