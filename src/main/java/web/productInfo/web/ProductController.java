package web.productInfo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import web.productInfo.service.ProductEntityService;

import java.sql.Timestamp;

/**
 * Created by WEO on 1/4/17.
 */
@Controller
@EnableWebMvc
public class ProductController {

    @Autowired
    private ProductEntityService productEntityService;

    @RequestMapping(value = "/price_history", method = RequestMethod.GET)
    @ResponseBody
    public String getReportPriceHistory() {

        return productEntityService.findAllByName("Livepath").toString();
    }

    @RequestMapping(value = "/actual_price", method = RequestMethod.GET)
    @ResponseBody
    public String getReportActualPrice() {

        return productEntityService.findAllByTimestamp(Timestamp.valueOf("2017-01-06 00:59:44")).toString();
    }

}
