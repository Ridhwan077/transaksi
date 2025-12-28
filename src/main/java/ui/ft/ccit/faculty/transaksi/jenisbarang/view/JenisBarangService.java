package ui.ft.ccit.faculty.transaksi.jenisbarang.view;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ui.ft.ccit.faculty.transaksi.DataAlreadyExistsException;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.jenisbarang.model.JenisBarangRepository;
import ui.ft.ccit.faculty.transaksi.jenisbarang.model.JenisBarang;

import java.util.List;

@Service
@Transactional
public class JenisBarangService {

    private final JenisBarangRepository jenisBarangRepository;

    public JenisBarangService(JenisBarangRepository jenisBarangRepository) {
        this.jenisBarangRepository = jenisBarangRepository;
    }

    public List<JenisBarang> getAll() {
        return jenisBarangRepository.findAll();
    }

    public JenisBarang getById(Integer id) {
        return jenisBarangRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("JenisBarang", String.valueOf(id)));
    }

    public List<JenisBarang> searchByNama(String keyword) {
        return jenisBarangRepository.findByNamaJenisContainingIgnoreCase(keyword);
    }

    // CREATE
    public JenisBarang save(JenisBarang jenisBarang) {
        // Validasi ID (optional, karena auto-increment biasanya ID null saat create)
        // Tapi jika logic bisnis mengharuskan ID diisi manual:
        /*
        if (jenisBarang.getIdJenisBarang() == null) {
             throw new IllegalArgumentException("idJenisBarang wajib diisi");
        }
        */
        
        // Cek duplicate ID jika perlu (biasanya ditangani DB constraint)
        if (jenisBarang.getIdJenisBarang() != null && jenisBarangRepository.existsById(jenisBarang.getIdJenisBarang())) {
             throw new DataAlreadyExistsException("JenisBarang", String.valueOf(jenisBarang.getIdJenisBarang()));
        }

        return jenisBarangRepository.save(jenisBarang);
    }

    // UPDATE
    public JenisBarang update(Integer id, JenisBarang updated) {
        JenisBarang existing = getById(id); // akan lempar DataNotFoundException

        existing.setIdJenisBarang(updated.getIdJenisBarang());
        existing.setNamaJenis(updated.getNamaJenis());

        return jenisBarangRepository.save(existing);
    }

    // DELETE
    public void delete(Integer id) {
        if (!jenisBarangRepository.existsById(id)) {
            throw new DataNotFoundException("JenisBarang", String.valueOf(id));
        }
        jenisBarangRepository.deleteById(id);
    }
}
