package controller;

import dto.Exposer;
import dto.PurchaseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;
import service.PurchaseService;

import java.util.Date;

@Controller
public class PurchaseController {

    private final ProductService productService;
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, ProductService productService) {
        this.purchaseService = purchaseService;
        this.productService = productService;
    }

    @RequestMapping("/purchaseList")
    public ModelAndView purchaseList(){
        return new ModelAndView("purchaseList")
                .addObject("list", purchaseService.queryAll());
    }

    @RequestMapping("/{id}/detail")
    public ModelAndView detail(@PathVariable("id")int productID){
        return new ModelAndView("detail")
                .addObject("product", productService.queryByID(productID))
                .addObject("purchaseID", purchaseService.queryByProductID(productID).getPurchaseID());
    }

    @RequestMapping("/{id}/execute")
    public ModelAndView execute(@PathVariable("id")int purchaseID){
        ModelAndView modelAndView = new ModelAndView("error");
        Exposer exposer = purchaseService.exposeURL(purchaseID);
        if (!exposer.isExposed() && exposer.getStartTime() > new Date().getTime()){
            return modelAndView.addObject("message", "don't open yet");
        } else if (!exposer.isExposed() && exposer.getEndTime() < new Date().getTime()){
            return modelAndView.addObject("message", "already closed");
        }
        PurchaseExecutor executor = purchaseService.executePurchase(purchaseID, 1234);
        if (executor.getSuccess() == null){
            return modelAndView.addObject("message", "purchase failed");
        }
        return new ModelAndView("purchase")
                .addObject("name", productService.queryByPurchaseID(purchaseID).getName());
    }
}
