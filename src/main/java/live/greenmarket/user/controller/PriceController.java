package live.greenmarket.user.controller;

import live.greenmarket.user.model.domain.PriceModel;
import live.greenmarket.user.model.domain.UserModel;
import live.greenmarket.user.model.entity.PriceEntity;
import live.greenmarket.user.model.entity.UserEntity;
import live.greenmarket.user.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;
    @GetMapping("path")
    public List<PriceEntity> findAll() {
        return priceService.findAll();
    }

    @PostMapping("path")
    public PriceEntity save(PriceModel priceModel) {
        return priceService.save(priceModel);
    }

    @GetMapping("path")
    public Optional<PriceEntity> findAllById(Long id) {
        return priceService.findById(id);
    }

    @GetMapping("path")
    public boolean existsById(Long id) {
        return priceService.existsById(id);
    }

    @GetMapping("path")
    public long count() {
        return priceService.count();
    }

    @DeleteMapping("path")
    public void deleteById(Long id) { priceService.deleteById(id);
    }
}
