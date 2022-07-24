import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;

class tiket
{
	public String pilihhari()
	{
		String h;
		String[] namahari = {"SENIN", "SELASA", "RABU", "KAMIS", "JUM'AT", "SABTU", "MINGGU"};
		Object[] hari = {"PILIH HARI PENAYANGAN"};

		h = (String) JOptionPane.showInputDialog(null, hari, "HARI",JOptionPane.PLAIN_MESSAGE,null, namahari,null);
		return h;
	}

	public String pilihjam()
	{
		String j;
		String[] jamdaftar = {"11:00 WIB", "13:00 WIB", "15:00 WIB", "17:00 WIB", "19:00 WIB", "21:00 WIB"};
		Object[] jam = {"PILIH JAM PENAYANGAN"};

		j = (String) JOptionPane.showInputDialog(null, jam, "JAM",JOptionPane.PLAIN_MESSAGE,null, jamdaftar,null);
		return j;
	}
	
	public String pilihkursi()
	{
		String k;
		String[] daftarkursi= {"A-1", "A-2", "A-3", "A-4", "A-5", "A-6", "A-7", "A-8", "A-9", "A-10", 
								"B-1", "B-2", "B-3", "B-4", "B-5", "B-6", "B-7", "B-8", "B-9", "B-10"};
		Object[] kursi = {"PILIH KURSI (mengulang sebanyak jumlah tiket)"};

		k = (String) JOptionPane.showInputDialog(null, kursi, "KURSI",JOptionPane.PLAIN_MESSAGE, null, daftarkursi,null);
		return k;
	}	
}

class cetak extends tiket
{
	public void print()
	{
		String day, hour, sementara, seat , tempatduduk = " ";
		int jumlah = 0, i, harga, payment, balik;
		do
		{
			balik = 0;
			sementara = JOptionPane.showInputDialog(null, "MASUKKAN JUMLAH PEMBELIAN TIKET", "JUMLAH", JOptionPane.PLAIN_MESSAGE);
			if (sementara == " ")
			{
				balik = 1;
			}
			else
				jumlah = Integer.parseInt(sementara);
		}
		while (balik == 1);

		day = super.pilihhari();
		hour = super.pilihjam();

		for (i =1; i <=jumlah ; i++ )
		{
			tempatduduk = tempatduduk + super.pilihkursi() + " ";
		}

		if (day == "JUM'AT")
		{
			harga = 40000;
		}
		else if ((day == "SABTU") || (day == "MINGGU"))
		{
			harga = 50000;
		}
		else
			harga = 25000;
		
		payment = harga * jumlah;
		
		seat = tempatduduk;
		Object[] mencetak = {
			"TIKET ANDA\n\n",
			"HARI : " + day,
			"JAM : " + hour,
			"KURSI :" + seat,
			"\nTOTAL PEMBAYARAN : " + payment,
			"\nE-Bioskop 2022."};
		JOptionPane.showMessageDialog(null,
			mencetak
			);
	}
}

public class Bioskop 
{
	public static void main(String[] args) 
	{
		cetak kertas = new cetak();
		Object[] sapa = {"E-Tiket Bioskop"};
		JOptionPane.showMessageDialog(null, sapa, " ", JOptionPane.PLAIN_MESSAGE);
		kertas.print();
	}
}
