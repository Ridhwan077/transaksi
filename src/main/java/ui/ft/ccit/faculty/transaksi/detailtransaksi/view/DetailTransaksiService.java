package ui.ft.ccit.faculty.transaksi.detailtransaksi.view;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ui.ft.ccit.faculty.transaksi.DataAlreadyExistsException;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.model.DetailTransaksi;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.model.DetailTransaksiId;
import ui.ft.ccit.faculty.transaksi.detailtransaksi.model.DetailTransaksiRepository;

import java.util.List;

@Service
@Transactional
public class DetailTransaksiService {

    private final DetailTransaksiRepository repository;

    public DetailTransaksiService(DetailTransaksiRepository repository) {
        this.repository = repository;
    }

    public List<DetailTransaksi> getAll() {
        return repository.findAll();
    }

    public List<DetailTransaksi> getByTransaksi(String kodeTransaksi) {
        return repository.findByKodeTransaksi(kodeTransaksi);
    }

    public DetailTransaksi getById(String kodeTransaksi, String idBarang) {
        DetailTransaksiId id = new DetailTransaksiId(kodeTransaksi, idBarang);
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("DetailTransaksi", kodeTransaksi + "-" + idBarang));
    }

    public DetailTransaksi save(DetailTransaksi detail) {
        DetailTransaksiId id = new DetailTransaksiId(detail.getKodeTransaksi(), detail.getIdBarang());
        if (repository.existsById(id)) {
            throw new DataAlreadyExistsException("DetailTransaksi", detail.getKodeTransaksi() + "-" + detail.getIdBarang());
        }
        return repository.save(detail);
    }

    public DetailTransaksi update(String kodeTransaksi, String idBarang, DetailTransaksi updated) {
        DetailTransaksi existing = getById(kodeTransaksi, idBarang);
        existing.setJumlah(updated.getJumlah());
        return repository.save(existing);
    }

    public void delete(String kodeTransaksi, String idBarang) {
        DetailTransaksiId id = new DetailTransaksiId(kodeTransaksi, idBarang);
        if (!repository.existsById(id)) {
            throw new DataNotFoundException("DetailTransaksi", kodeTransaksi + "-" + idBarang);
        }
        repository.deleteById(id);
    }
}
