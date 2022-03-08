package academy.lgs.service.impl;

import java.util.List;

import academy.lgs.dao.BucketDao;
import academy.lgs.dao.impl.BucketDaoImpl;
import academy.lgs.domain.Bucket;
import academy.lgs.service.BucketService;

public class BucketServiceImpl implements BucketService {

	private BucketDao bucketDao;
	private static BucketService bucketServiceImpl;
//	private static Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);

	private BucketServiceImpl() {
		bucketDao = new BucketDaoImpl();
	}

	public static BucketService getBucketService() {
		if (bucketServiceImpl == null) {
			bucketServiceImpl = new BucketServiceImpl();
		}

		return bucketServiceImpl;
	}

	@Override
	public Bucket create(Bucket t) {
		return bucketDao.create(t);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket t) {
		return bucketDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

}
