package live.greenmarket.user.controller;

import live.greenmarket.user.model.entity.HotelEntity;
import live.greenmarket.user.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/hotels")
public class HotelController {


    private final HotelService hotelService;

    @GetMapping("findAll")
    public List<HotelEntity> findAll() {
        return hotelService.findAll();
    }


    @GetMapping("findById")
    public Optional<HotelEntity> findById(Long id) {
        return hotelService.findById(id);
    }

    @GetMapping("existsById")
    public boolean existsById(Long id) {
        return hotelService.existsById(id);
    }

    @GetMapping("count")
    public long count() {
        return hotelService.count();
    }

    @DeleteMapping("deleteById")
    public void deleteById(Long id) { hotelService.deleteById(id);
    }
}
