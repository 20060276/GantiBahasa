package simple.example.hewanpedia;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import simple.example.hewanpedia.model.Anjing;
import simple.example.hewanpedia.model.Hewan;
import simple.example.hewanpedia.model.Kucing;
import simple.example.hewanpedia.model.Buah;

public class DataProvider {
    private static List<Hewan> hewans = new ArrayList<>();

    private static List<Kucing> initDataKucing(Context ctx) {
        List<Kucing> kucings = new ArrayList<>();
        kucings.add(new Kucing(ctx.getString(R.string.as), ctx.getString(R.string.asanggora),
                ctx.getString(R.string.asdeskripri), R.drawable.cat_angora));
        kucings.add(new Kucing(ctx.getString(R.string.lo), ctx.getString(R.string.lobengal),
                ctx.getString(R.string.lodesk), R.drawable.cat_bengal));
        kucings.add(new Kucing(ctx.getString(R.string.na), ctx.getString(R.string.namyan),
                ctx.getString(R.string.nadeskrip), R.drawable.cat_birman));
        kucings.add(new Kucing(ctx.getString(R.string.pe), ctx.getString(R.string.peiran),
                ctx.getString(R.string.pede), R.drawable.cat_persia));
        kucings.add(new Kucing(ctx.getString(R.string.dos), ctx.getString(R.string.dosth),
                ctx.getString(R.string.dosde), R.drawable.cat_siam));
        kucings.add(new Kucing(ctx.getString(R.string.mor), ctx.getString(R.string.morus),
                ctx.getString(R.string.mordes), R.drawable.cat_siberian));
        return kucings;
    }

    private static List<Anjing> initDataAnjing(Context ctx) {
        List<Anjing> anjings = new ArrayList<>();
        anjings.add(new Anjing(ctx.getString(R.string.me), ctx.getString(R.string.meso),
                ctx.getString(R.string.medal), R.drawable.dog_bulldog));
        anjings.add(new Anjing(ctx.getString(R.string.bas), ctx.getString(R.string.basew),
                ctx.getString(R.string.basde), R.drawable.dog_husky));
        anjings.add(new Anjing(ctx.getString(R.string.ky), ctx.getString(R.string.kyaa),
                ctx.getString(R.string.kyads), R.drawable.dog_kintamani));
        anjings.add(new Anjing(ctx.getString(R.string.oma), ctx.getString(R.string.omaho),
                ctx.getString(R.string.omadesk), R.drawable.dog_samoyed));
        anjings.add(new Anjing(ctx.getString(R.string.ud), ctx.getString(R.string.udil),
                ctx.getString(R.string.udah), R.drawable.dog_shepherd));
        anjings.add(new Anjing(ctx.getString(R.string.amb), ctx.getString(R.string.ambo),
                ctx.getString(R.string.ambang), R.drawable.dog_shiba));
        return anjings;
    }

    private static List<Buah> initDataBuah(Context ctx) {
        List<Buah> buahs = new ArrayList<>();
        buahs.add(new Buah(ctx.getString(R.string.ram), ctx.getString(R.string.rambut),
                ctx.getString(R.string.rambutan), R.drawable.rambutan));
        buahs.add(new Buah(ctx.getString(R.string.sya), ctx.getString(R.string.ban),
                ctx.getString(R.string.syabany), R.drawable.kelengkeng));
        buahs.add(new Buah(ctx.getString(R.string.sir), ctx.getString(R.string.sak),
                ctx.getString(R.string.sirsak), R.drawable.sirsak));
        buahs.add(new Buah(ctx.getString(R.string.buah), ctx.getString(R.string.andai),
                ctx.getString(R.string.elka), R.drawable.buah_naga));
        buahs.add(new Buah(ctx.getString(R.string.anya), ctx.getString(R.string.ema),
                ctx.getString(R.string.liha), R.drawable.sawo_mentega));
        buahs.add(new Buah(ctx.getString(R.string.ery), ctx.getString(R.string.woke),
                ctx.getString(R.string.bemo), R.drawable.berry));
        return buahs;
    }

    private static void initAllHewans(Context ctx) {
        hewans.addAll(initDataKucing(ctx));
        hewans.addAll(initDataAnjing(ctx));
        hewans.addAll((Collection<? extends Hewan>) initDataBuah(ctx));
    }

    public static List<Hewan> getAllHewan(Context ctx) {
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        return  hewans;
    }

    public static List<Hewan> getHewansByTipe(Context ctx, String jenis) {
        List<Hewan> hewansByType = new ArrayList<>();
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        for (Hewan h : hewans) {
            if (h.getJenis().equals(jenis)) {
                hewansByType.add(h);
            }
        }
        return hewansByType;
    }

}
