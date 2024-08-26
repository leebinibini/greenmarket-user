package live.greenmarket.user.controller;

import live.greenmarket.user.model.domain.HotelModel;
import live.greenmarket.user.model.domain.UserModel;
import live.greenmarket.user.model.entity.HotelEntity;
import live.greenmarket.user.model.entity.UserEntity;
import live.greenmarket.user.service.HotelService;
import live.greenmarket.user.service.UserService;
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
@RequestMapping("/hotels")
public class HotelController {


    private final HotelService hotelService;

    @GetMapping("path")
    public List<HotelEntity> findAll() {
        return hotelService.findAll();
    }

    @PostMapping("path")
    public HotelEntity save(HotelModel hotelModel) {
        return hotelService.save(hotelModel);
    }

    @GetMapping("path")
    public Optional<HotelEntity> findAllById(Long id) {
        return hotelService.findById(id);
    }

    @GetMapping("path")
    public boolean existsById(Long id) {
        return hotelService.existsById(id);
    }

    @GetMapping("path")
    public long count() {
        return hotelService.count();
    }

    @DeleteMapping("path")
    public void deleteById(Long id) { hotelService.deleteById(id);
    }
}
