from icrawler.builtin import BingImageCrawler

celebs = ['Shahrukh Khan', 'Rashmika Mandanna', 'Kiara Advani',
          'Varun Dhavan', 'Rajkumar Rao', 'Ayushman Khurana']

numbers = 30

for celeb in celebs:
    bing_crawler = BingImageCrawler(
        storage={'root_dir': 'img/{}'.format(celeb)})
    bing_crawler.crawl(keyword=celeb, filters=None, offset=0, max_num=numbers)
