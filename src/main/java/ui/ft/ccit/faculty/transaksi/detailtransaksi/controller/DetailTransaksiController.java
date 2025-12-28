package ui.ft.ccit.faculty.transaksi.detailtransaksi.controller;

import org.springframework.web.bind.annotation.*;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.model.DetailTransaksi;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.view.DetailTransaksiService;

import java.util.List;

@RestController
@RequestMapping("/api/detail-transaksi")
public class DetailTransaksiController {

    private final DetailTransaksiService service;

    public DetailTransaksiController(DetailTransaksiService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetailTransaksi> list() {
        return service.getAll();
    }

    @GetMapping("/by-transaksi/{kodeTransaksi}")
    public List<DetailTransaksi> listByTransaksi(@PathVariable String kodeTransaksi) {
        return service.getByTransaksi(kodeTransaksi);
    }

    @GetMapping("/{kodeTransaksi}/{idBarang}")
    public DetailTransaksi get(@PathVariable String kodeTransaksi, @PathVariable String idBarang) {
        return service.getById(kodeTransaksi, idBarang);
    }

    @PostMapping
    public DetailTransaksi create(@RequestBody DetailTransaksi detail) {
        return service.save(detail);
    }

    @PutMapping("/{kodeTransaksi}/{idBarang}")
    public DetailTransaksi update(@PathVariable String kodeTransaksi, @PathVariable String idBarang, @RequestBody DetailTransaksi detail) {
        return service.update(kodeTransaksi, idBarang, detail);
    }

    @DeleteMapping("/{kodeTransaksi}/{idBarang}")
    public void delete(@PathVariable String kodeTransaksi, @PathVariable String idBarang) {
        service.delete(kodeTransaksi, idBarang);
    }
}
