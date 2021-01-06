from icrawler.builtin import BingImageCrawler

celebs = ['Shahrukh Khan', 'Rashmika Mandanna', 'Kiara Advani',
          'Rajkumar Rao', 'Ayushman Khurana']

numbers = 1

for fi_offset, celeb in enumerate(celebs):
    bic = BingImageCrawler(storage={'root_dir': 'img/'})
    bic.crawl(keyword=celeb, filters=None, max_num=numbers,
              offset=50, file_idx_offset=fi_offset)
