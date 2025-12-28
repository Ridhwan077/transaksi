package ui.ft.ccit.faculty.transaksi.transaksi.controller;

import org.springframework.web.bind.annotation.*;
import ui.ft.ccit.faculty.transaksi.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.transaksi.view.TransaksiService;

import java.util.List;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    private final TransaksiService service;

    public TransaksiController(TransaksiService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaksi> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Transaksi get(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Transaksi create(@RequestBody Transaksi transaksi) {
        return service.save(transaksi);
    }

    @PutMapping("/{id}")
    public Transaksi update(@PathVariable String id, @RequestBody Transaksi transaksi) {
        return service.update(id, transaksi);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
