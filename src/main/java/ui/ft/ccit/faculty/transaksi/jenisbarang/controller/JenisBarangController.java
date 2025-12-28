package ui.ft.ccit.faculty.transaksi.jenisbarang.controller;

import org.springframework.web.bind.annotation.*;
import ui.ft.ccit.faculty.transaksi.jenisbarang.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.jenisbarang.view.JenisBarangService;

import java.util.List;

@RestController
@RequestMapping("/api/jenisbarang")
public class JenisBarangController {

    private final JenisBarangService service;

    public JenisBarangController(JenisBarangService service) {
        this.service = service;
    }

    // GET list semua barang
    @GetMapping
    public List<JenisBarang> list() {
        return service.getAll();
    }

    // GET satu barang by id
    @GetMapping("/{id}")
    public JenisBarang get(@PathVariable Integer id) {
        return service.getById(id);
    }

    // SEARCH by nama
    @GetMapping("/search")
    public List<JenisBarang> search(@RequestParam String q) {
        return service.searchByNama(q);
    }

    // POST - create barang baru
    @PostMapping
    public JenisBarang create(@RequestBody JenisBarang barang) {
        return service.save(barang);
    }

    // PUT - edit/update barang
    @PutMapping("/{id}")
    public JenisBarang update(@PathVariable Integer id, @RequestBody JenisBarang barang) {
        return service.update(id, barang);
    }

    // DELETE - hapus barang
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
